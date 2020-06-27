package com.liukun.androideasymvp.mvp.base;

import android.content.Context;

/**
 * Author: liukun on 2020/6/25.
 * Mail  : 3266817262@qq.com
 * Description: MVP View 的基类接口
 */
public interface IBaseView {
    /**
     * 显示加载框
     */
    public void showLoading();

    /**
     * 隐藏加载框
     */
    public void hideLoading();

    /**
     * 空数据
     *
     * @param tag Tag
     */
    public void onEmpty(Object tag);

    /**
     * 错误信息
     *
     * @param tag TAG
     * @param errorMessage 错误信息
     */
    public void onError(Object tag, String errorMessage);


}
