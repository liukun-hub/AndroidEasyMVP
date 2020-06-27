package com.liukun.androideasymvp.ui.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.liukun.androideasymvp.R;
import com.liukun.base.BaseDialog;
import com.liukun.base.action.AnimAction;


/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description:隐私协议的弹框
 */
public final class PrivacyDialog {

    public static final class Builder
            extends BaseDialog.Builder<Builder> {
        Button btnOK;
        Button btnCancel;
        private OnClickListener mOnClickListener;

        public Builder(Context context) {
            super(context);

            setContentView(R.layout.dialog_privacy);
            setAnimStyle(AnimAction.BOTTOM);
            setGravity(Gravity.CENTER);
            btnCancel = findViewById(R.id.btn_cancel);
            btnOK = findViewById(R.id.btn_ok);


        }

        public Builder setOnClickListener(OnClickListener mOnClickListener) {
            btnOK.setOnClickListener(mOnClickListener::OnClickOkListener);
            btnCancel.setOnClickListener(mOnClickListener::OnClickCancelListener);
            return this;
        }

        public interface OnClickListener {
            void OnClickOkListener(View view);

            void OnClickCancelListener(View view);
        }
    }

}