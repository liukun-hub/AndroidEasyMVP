package com.liukun.androideasymvp.action;

import com.hjq.toast.ToastUtils;

import androidx.annotation.StringRes;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public interface ToastAction {
    default void toast(CharSequence text) {
        ToastUtils.show(text);
    }

    default void toast(@StringRes int id) {
        ToastUtils.show(id);
    }

    default void toast(Object object) {
        ToastUtils.show(object);
    }
}
