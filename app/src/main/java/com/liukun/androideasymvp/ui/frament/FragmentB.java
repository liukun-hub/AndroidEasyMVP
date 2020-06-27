package com.liukun.androideasymvp.ui.frament;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.commom.MessageWrap;
import com.liukun.androideasymvp.commom.MyFragment;
import com.liukun.androideasymvp.mvp.base.BaseMvpFragment;
import com.liukun.androideasymvp.ui.activity.HomeActivity;
import com.liukun.androideasymvp.ui.bean.ChaptersBean;

/**
 *
 */
public final class FragmentB extends BaseMvpFragment {
    TextView textView;
    TextView textView2;

    public static FragmentB newInstance() {
        return new FragmentB();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_b;
    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.text);
        textView2 = findViewById(R.id.text2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initData() {

    }


    @Override
    public void getStickyMessage(MessageWrap<?> messageWrap) {
        ChaptersBean message = (ChaptersBean) messageWrap.getMessage();
        Log.d("ssss", "getMessagesss: " + messageWrap.getMessage());
        switch ((int)messageWrap.getCode()){
            case 0:
                Log.d("ssss", "getMessagesss: " + messageWrap.getMessage()+message.getName());
                textView.setText("sss");
                textView.setText(message.getName()+"sss");
                break;
            case 1:
                Log.d("ssss", "getMessagesss222: " + messageWrap.getMessage());
                textView2.setText(message.getName());
                break;
        }
    }

}