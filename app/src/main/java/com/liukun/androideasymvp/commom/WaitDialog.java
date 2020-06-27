package com.liukun.androideasymvp.commom;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.liukun.androideasymvp.R;
import com.liukun.base.BaseDialog;
import com.liukun.base.action.AnimAction;

import androidx.annotation.StringRes;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description:等待加载对话框
 */
public final class WaitDialog {
    public static final class Builder
            extends BaseDialog.Builder<Builder> {

        private final TextView mMessageView;

        public Builder(Context context) {
            super(context);
            setContentView(R.layout.dialog_wait);
            setAnimStyle(AnimAction.TOAST);
            setBackgroundDimEnabled(false);
            setCancelable(false);

            mMessageView = findViewById(R.id.tv_wait_message);
        }

        public Builder setMessage(@StringRes int id) {
            return setMessage(getString(id));
        }
        public Builder setMessage(CharSequence text) {
            mMessageView.setText(text);
            mMessageView.setVisibility(text == null ? View.GONE : View.VISIBLE);
            return this;
        }
    }
}
