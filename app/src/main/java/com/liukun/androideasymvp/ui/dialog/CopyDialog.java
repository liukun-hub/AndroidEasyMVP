package com.liukun.androideasymvp.ui.dialog;

import android.content.Context;
import android.view.Gravity;

import com.liukun.androideasymvp.R;
import com.liukun.base.BaseDialog;
import com.liukun.base.action.AnimAction;


/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description: 可进行拷贝的副本
 */
public final class CopyDialog {

    public static final class Builder
            extends BaseDialog.Builder<Builder> {

        public Builder(Context context) {
            super(context);

            setContentView(R.layout.dialog_copy);
            setAnimStyle(AnimAction.BOTTOM);
            setGravity(Gravity.BOTTOM);
        }



    }
}