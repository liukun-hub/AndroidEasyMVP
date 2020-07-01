package com.liukun.base.net.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.liukun.base.net.imageloader.glide.ImageConfigImpl;

/**
 * Author: liukun on 2020/6/27.
 * Mail  : 3266817262@qq.com
 * Description: 调用图片请求框架的工具类
 */
public class ImageLoader {
    private static IBaseImageStrategy mImageStrategy;

    public IBaseImageStrategy<?> getImageStrategy() {
        return mImageStrategy;
    }

    /**
     * 设置图片框架请求策略
     *
     * @param imageStrategy 图片请求框架策略 需要实现{@link IBaseImageStrategy}
     */
    public static void setImageStrategy(IBaseImageStrategy<?> imageStrategy) {
        if (imageStrategy != null) {
            mImageStrategy = imageStrategy;
        } else {
            throw new RuntimeException("image request strategy can`t null !");
        }
    }

    public static <T extends ImageConfig> void loadImage(Context context, T config) {

        if (mImageStrategy != null) {
            mImageStrategy.loadImage(context, config);
        } else {
            throw new RuntimeException("image request strategy can`t null !");
        }

    }

    public static <T extends ImageConfig> void clear(Context context, T config) {
        if (mImageStrategy != null) {
            mImageStrategy.clear(context, config);
        } else {
            throw new RuntimeException("image request strategy can`t null !");
        }
    }

    public static void loadImage(Context context, String url, ImageView imageView) {
        loadImage(context, ImageConfigImpl.builder()
                .setUrl(url)
                .setImageView(imageView)
                .build());
    }

    public static void loadImage(Context context, String url, int placeholder, ImageView imageView) {
        loadImage(context, ImageConfigImpl.builder()
                .setUrl(url)
                .setPlaceholder(placeholder)
                .setImageView(imageView)
                .build());
    }

    public static void loadImage(Context context, String url, int placeholder, int errorPic, ImageView imageView) {
        loadImage(context, ImageConfigImpl.builder()
                .setUrl(url)
                .setPlaceholder(placeholder)
                .setErrorPic(errorPic)
                .setImageView(imageView)
                .build());
    }
}
