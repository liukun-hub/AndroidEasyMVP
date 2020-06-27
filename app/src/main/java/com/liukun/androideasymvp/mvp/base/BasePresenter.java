package com.liukun.androideasymvp.mvp.base;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * Author: liukun on 2020/6/25.
 * Mail  : 3266817262@qq.com
 * Description:Presenter 基类
 */
public abstract class BasePresenter<M extends BaseModel, V extends IBaseView> {

    public M mModel;
    private V mProxyView;
    private WeakReference<V> mVWeakReference;

    /**
     * 绑定View
     *
     * @param view V
     */
    @SuppressWarnings({"unchecked"})
    public void attachView(V view) {
        mVWeakReference = new WeakReference<>(view);
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader()
                , view.getClass().getInterfaces()
                , new MvpViewHandler(mVWeakReference.get()));
        if (mModel == null) {
            //通过反射生成model对象
            ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
            if (parameterizedType != null) {
                Type[] params = parameterizedType.getActualTypeArguments();
                try {
                    mModel = (M) ((Class<?>)params[0]).newInstance();
                } catch (IllegalAccessException | InstantiationException e) {
                    Log.d("ssss", "attachView: "+e.toString());
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 解绑View
     */
    public void detachView() {
        this.mModel = null;
        if (isViewAttached()) {
            mVWeakReference.clear();
            mVWeakReference = null;
        }
    }

    /**
     * 判断是否与View建立连接
     *
     * @return true 与View建立连接
     */
    protected boolean isViewAttached() {
        return mVWeakReference != null && mVWeakReference.get() != null;
    }


    public M getModel() {
        return mModel;
    }

    protected V getView() {
        return mProxyView;
    }

    /**
     * View代理类  防止页面关闭P异步操作调用V方法导致的空指针问题
     */
    private class MvpViewHandler implements InvocationHandler {

        private IBaseView mBaseView;

        public MvpViewHandler(IBaseView baseView) {
            mBaseView = baseView;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //如果V层没被销毁, 执行V层的方法.
            if (isViewAttached()) {
                return method.invoke(mBaseView, args);
            }
            return null;
        }
    }
}
