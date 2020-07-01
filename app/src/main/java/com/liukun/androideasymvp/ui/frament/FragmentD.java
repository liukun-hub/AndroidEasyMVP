package com.liukun.androideasymvp.ui.frament;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.mvp.base.BaseMvpFragment;
import com.liukun.base.net.imageloader.ImageLoader;
import com.liukun.base.net.imageloader.glide.ImageConfigImpl;

import butterknife.BindView;

/**
 *
 */
public final class FragmentD extends BaseMvpFragment {

    @BindView(R.id.image)
    ImageView mImage;
    @BindView(R.id.image2)
    ImageView mImage2;

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

        showLoading();
        ImageLoader.loadImage(getContext(), ImageConfigImpl.builder()
                .setUrl("http://lauzy.me/img/home-bg.jpg")
                .setPlaceholder(R.mipmap.ic_launcher)
                .setImageView(mImage).build());

        ImageLoader.loadImage(getContext(),
                "https://img-blog.csdnimg.cn/20190929163247272.png?x-oss-process=image" +
                        "/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNz" +
                        "ZG4ubmV0L2Rkbm9zaA==,size_16,color_FFFFFF,t_70", mImage2);

        hideLoading();

    }
}