package com.liukun.androideasymvp.ui.frament;

import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.commom.MyFragment;
import com.liukun.androideasymvp.mvp.base.BaseMvpFragment;
import com.liukun.androideasymvp.ui.activity.HomeActivity;

/**
 *
 */
public final class FragmentD extends BaseMvpFragment {

    public static FragmentD newInstance() {
        return new FragmentD();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_d;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}