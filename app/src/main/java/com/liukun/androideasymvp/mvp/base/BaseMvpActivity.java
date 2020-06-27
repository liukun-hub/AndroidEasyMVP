package com.liukun.androideasymvp.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.liukun.androideasymvp.commom.MyActivity;
import com.liukun.androideasymvp.mvp.inject.InjectPresenter;
import com.liukun.base.BaseActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: liukun on 2020/6/26.
 * Mail  : 3266817262@qq.com
 * Description: Mvp基类 Activity
 */
public abstract class BaseMvpActivity extends MyActivity implements IBaseView {

    List<BasePresenter> mBasePresenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBasePresenters = new ArrayList<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            if (injectPresenter != null) {
                Class<? extends BasePresenter> presenterClass = null;
                try {
                    presenterClass = (Class<? extends BasePresenter>) field.getType();
                } catch (Exception e) {
                    throw new RuntimeException("not support inject presenter :" + field.getType());
                }
                try {
                    BasePresenter presenter = presenterClass.newInstance();
                    presenter.attachView(this);
                    mBasePresenters.add(presenter);
                    field.setAccessible(true);
                    field.set(this, presenter);
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void showLoading() {
        showDialog();
    }

    @Override
    public void hideLoading() {
        hideDialog();
    }

    @Override
    public void onEmpty(Object tag) {

    }

    @Override
    public void onError(Object tag, String errorMessage) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBasePresenters != null) {
            for (BasePresenter basePresenter : mBasePresenters) {
                basePresenter.detachView();
            }
        }
    }
}
