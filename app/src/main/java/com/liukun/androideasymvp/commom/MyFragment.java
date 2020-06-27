package com.liukun.androideasymvp.commom;

import android.view.ViewGroup;

import com.gyf.immersionbar.ImmersionBar;
import com.hjq.bar.TitleBar;
import com.liukun.androideasymvp.action.TitleBarAction;
import com.liukun.androideasymvp.action.ToastAction;
import com.liukun.androideasymvp.helper.EventBusHelper;
import com.liukun.base.BaseFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description: app项目中 Fragment 懒加载基类
 */
public abstract class MyFragment<A extends MyActivity> extends BaseFragment<A>
        implements ToastAction, TitleBarAction {

    /**
     * 标题栏对象
     */
    private TitleBar mTitleBar;
    /**
     * 状态栏沉浸
     */
    private ImmersionBar mImmersionBar;

    @Override
    protected void initFragment() {
        ButterKnife.bind(this, getView());

        if (getTitleBar() != null) {
            getTitleBar().setOnTitleBarListener(this);
        }

        initImmersion();
        super.initFragment();
        EventBusHelper.register(this);
    }

    /**
     * 初始化沉浸式
     */
    protected void initImmersion() {
        // 初始化沉浸式状态栏
        if (isStatusBarEnabled()) {
            statusBarConfig().init();
            // 设置标题栏沉浸
            if (mTitleBar != null) {
                ImmersionBar.setTitleBar(this, mTitleBar);
            }
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getStickyMessage(MessageWrap<?> messageWrap) {

    }

    /**
     * 是否在Fragment使用沉浸式
     */
    public boolean isStatusBarEnabled() {
        return false;
    }

    /**
     * 获取状态栏沉浸的配置对象
     */
    protected ImmersionBar getStatusBarConfig() {
        return mImmersionBar;
    }

    /**
     * 初始化沉浸式
     */
    private ImmersionBar statusBarConfig() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this)
                // 默认状态栏字体颜色为黑色
                .statusBarDarkFont(statusBarDarkFont())
                // 解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
                .keyboardEnable(true);
        return mImmersionBar;
    }

    /**
     * 获取状态栏字体颜色
     */
    protected boolean statusBarDarkFont() {
        // 返回真表示黑色字体
        return true;
    }

    @Override
    @Nullable
    public TitleBar getTitleBar() {
        if (mTitleBar == null) {
            mTitleBar = findTitleBar((ViewGroup) getView());
        }
        return mTitleBar;
    }

    /**
     * 当前加载对话框是否在显示中
     */
    public boolean isShowDialog() {
        return getAttachActivity().isShowDialog();
    }

    /**
     * 显示加载对话框
     */
    public void showDialog() {
        getAttachActivity().showDialog();
    }

    /**
     * 隐藏加载对话框
     */
    public void hideDialog() {
        getAttachActivity().hideDialog();
    }

    @Override
    public void onResume() {
        super.onResume();
        // 重新初始化状态栏
        statusBarConfig().init();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        EventBusHelper.unregister(this);
        super.onDestroy();
    }
}
