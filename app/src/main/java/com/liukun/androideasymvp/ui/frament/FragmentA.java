package com.liukun.androideasymvp.ui.frament;

import android.widget.TextView;

import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.commom.MessageWrap;
import com.liukun.androideasymvp.commom.MyFragment;
import com.liukun.androideasymvp.helper.EventBusHelper;
import com.liukun.androideasymvp.mvp.base.BaseMvpActivity;
import com.liukun.androideasymvp.mvp.base.BaseMvpFragment;
import com.liukun.androideasymvp.ui.activity.HomeActivity;
import com.liukun.androideasymvp.ui.bean.ChaptersBean;
import com.liukun.base.helper.LogUtil;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

/**
 *
 */
public final class FragmentA extends BaseMvpFragment {

    @BindView(R.id.text)
    TextView mText;

    public static FragmentA newInstance() {
        return new FragmentA();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        LogUtil.d("AAA", "initData");
        mText.setOnClickListener(this);
        mText.setOnClickListener(v -> {
            ChaptersBean chaptersBean = new ChaptersBean();
            chaptersBean.setName("我是从FragmentA来的");
            MessageWrap<ChaptersBean> chaptersBeanMessageWrap = new MessageWrap.Builder<ChaptersBean>()
                    .setMessage(chaptersBean)
                    .setCode(0)
                    .create();
            EventBusHelper.postStickyMessage(chaptersBeanMessageWrap);
        });
    }
}