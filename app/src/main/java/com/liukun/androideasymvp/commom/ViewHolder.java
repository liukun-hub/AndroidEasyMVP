package com.liukun.androideasymvp.commom;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/**
 *
 */
public class ViewHolder extends BaseViewHolder {

    public ViewHolder(View view) {
        super(view);
    }

    public ViewHolder loadCircleImage(int id, String url) {
        ImageView imageView = getView(id);
        Glide.with(MyApplication.getMyApplicationContext())
                .load(url)
                .circleCrop()
                .into(imageView);
        return this;
    }


    public ViewHolder loadImage(int id, String url) {
        ImageView imageView = getView(id);
        Glide.with(MyApplication.getMyApplicationContext())
                .load(url)
                //.error(R.mipmap.ic_head_placeholder)
                //.placeholder(R.mipmap.ic_head_placeholder)
                .into(imageView);
        return this;
    }

    /**
     * 获取头像
     * @param id
     * @param url
     * @return
     */
    public ViewHolder loadImageHeader(int id, String url) {
        ImageView imageView = getView(id);
        Glide.with(MyApplication.getMyApplicationContext())
                .load(url)
//                .error(R.mipmap.user_porfile_placehoder)
//                .placeholder(R.mipmap.user_porfile_placehoder)
                .into(imageView);
        return this;
    }


}
