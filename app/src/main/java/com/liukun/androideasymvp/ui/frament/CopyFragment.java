package com.liukun.androideasymvp.ui.frament;

import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.commom.MyFragment;
import com.liukun.androideasymvp.ui.activity.CopyActivity;

/**
 * 可进行拷贝的副本
 */
public final class CopyFragment extends MyFragment<CopyActivity> {

    public static CopyFragment newInstance() {
        return new CopyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_copy;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}