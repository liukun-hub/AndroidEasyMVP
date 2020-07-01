package com.liukun.androideasymvp.mvp.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liukun.androideasymvp.commom.MyActivity;
import com.liukun.androideasymvp.commom.MyFragment;
import com.liukun.androideasymvp.mvp.inject.InjectPresenter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Author: liukun on 2020/6/26.
 * Mail  : 3266817262@qq.com
 * Description: Mvp基类 Activity
 */
public abstract class BaseMvpFragment extends MyFragment<BaseMvpActivity> implements IBaseView {

    List<BasePresenter> mBasePresenters;

    @Override
    protected int getLayoutId() {
        return 0;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

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
                } catch (IllegalAccessException | InstantiationException | java.lang.InstantiationException e) {
                    e.printStackTrace();
                }

            }
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void onDestroy() {
        super.onDestroy();
        for (BasePresenter basePresenter : mBasePresenters) {
            basePresenter.detachView();
        }
    }
}
