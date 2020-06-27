package com.liukun.androideasymvp.commom;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.liukun.androideasymvp.R;

import java.util.Collection;
import java.util.List;

import androidx.annotation.Nullable;


/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description: app项目中的 Adapter 基类
 */
public abstract class BaseAdapter<T> extends BaseQuickAdapter<T, ViewHolder> {

    public BaseAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public BaseAdapter(int layoutResId, @Nullable List<T> data, boolean showEmpty) {
        this(layoutResId, data);
        if (showEmpty) {
            setEmptyView(R.layout.common_empty_view);
        }
    }


    @Override
    protected void convert(ViewHolder helper, T item) {
        bind(helper, item);
    }

    public abstract void bind(ViewHolder holder, T item);


    @Override
    public void addData(Collection<? extends T> newData) {
        if (newData != null) {
            super.addData(newData);
        }
    }


}