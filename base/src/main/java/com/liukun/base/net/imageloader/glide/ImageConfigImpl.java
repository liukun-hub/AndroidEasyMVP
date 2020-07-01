package com.liukun.base.net.imageloader.glide;

import android.app.AlertDialog.Builder;
import android.widget.ImageView;

import com.liukun.base.net.imageloader.ImageConfig;

/**
 * Author: liukun on 2020/6/27.
 * Mail  : 3266817262@qq.com
 * Description: 图片加载配置信息加载的参数 为了方便使用 使用构建者模式
 */
public class ImageConfigImpl extends ImageConfig {

    private int mFallBack;//请求 url 为空,则使用此图片作为占位
    private int mImageRadius;//圆角的大小
    private ImageView[] mImageViews;
    private int mBlurValue;// 高斯模糊 值越大越模糊
    private boolean isCrossFade;//是否使用淡入淡出过渡动画
    private boolean isCenterCrop;// 是否将图片剪切为 CenterCrop
    private boolean isCircle;// 是否将图片剪切为圆形
    private boolean isClearMemory;//是否清除内存缓存
    private boolean isClearDiskMemory;//是否清除磁盘缓存
    private @CacheStrategy.Strategy
    int cacheStrategy;//0对应DiskCacheStrategy.all,1对应DiskCacheStrategy.NONE,2对应DiskCacheStrategy.SOURCE,3对应DiskCacheStrategy.RESULT

    public ImageConfigImpl(Builder builder) {
        this.url = builder.url;
        this.imageView = builder.imageView;
        this.placeholder = builder.placeholder;
        this.errorPic = builder.errorPic;
        this.cacheStrategy = builder.cacheStrategy;
        mFallBack = builder.mFallBack;
        mImageRadius = builder.mImageRadius;
        mImageViews = builder.mImageViews;
        mBlurValue = builder.mBlurValue;
        this.isCrossFade = builder.isCrossFade;
        this.isCenterCrop = builder.isCenterCrop;
        this.isCircle = builder.isCircle;
        this.isClearMemory = builder.isClearMemory;
        this.isClearDiskMemory = builder.isClearDiskMemory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public @CacheStrategy.Strategy
    int getCacheStrategy() {
        return cacheStrategy;
    }

    public int getFallBack() {
        return mFallBack;
    }

    public int getImageRadius() {
        return mImageRadius;
    }

    public ImageView[] getImageViews() {
        return mImageViews;
    }

    public int getBlurValue() {
        return mBlurValue;
    }

    public boolean isBlurImage() {
        return mBlurValue > 0;
    }

    public boolean isImageRadius() {
        //如果设置了圆角大于0 那么就是允许圆角
        return mImageRadius > 0;
    }

    public boolean isCrossFade() {
        return isCrossFade;
    }

    public boolean isCenterCrop() {
        return isCenterCrop;
    }

    public boolean isCircle() {
        return isCircle;
    }

    public boolean isClearMemory() {
        return isClearMemory;
    }

    public boolean isClearDiskCache() {
        return isClearDiskMemory;
    }

    public static final class Builder {
        private String url;
        private ImageView imageView;
        private int placeholder;
        private int errorPic;

        private int mFallBack;//请求 url 为空,则使用此图片作为占位
        private int mImageRadius;//圆角的大小
        private ImageView[] mImageViews;
        private int mBlurValue;// 高斯模糊 值越大越模糊
        private boolean isCrossFade;//是否使用淡入淡出过渡动画
        private boolean isCenterCrop;// 是否将图片剪切为 CenterCrop
        private boolean isCircle;// 是否将图片剪切为圆形
        private boolean isClearMemory;//是否清除内存缓存
        private boolean isClearDiskMemory;//是否清除磁盘缓存
        private @CacheStrategy.Strategy
        int cacheStrategy;//0对应DiskCacheStrategy.all,1对应DiskCacheStrategy.NONE,2对应DiskCacheStrategy.SOURCE,3对应DiskCacheStrategy.RESULT

        private Builder() {
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setImageView(ImageView imageView) {
            this.imageView = imageView;
            return this;
        }

        public Builder setPlaceholder(int placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public Builder setErrorPic(int errorPic) {
            this.errorPic = errorPic;
            return this;
        }

        public Builder setFallBack(int fallBack) {
            mFallBack = fallBack;
            return this;
        }

        public Builder setImageRadius(int imageRadius) {
            mImageRadius = imageRadius;
            return this;
        }

        public Builder setImageViews(ImageView[] imageViews) {
            mImageViews = imageViews;
            return this;
        }

        public Builder setBlurValue(int blurValue) {
            mBlurValue = blurValue;
            return this;
        }

        public Builder setCrossFade(boolean crossFade) {
            isCrossFade = crossFade;
            return this;
        }

        public Builder setCenterCrop(boolean centerCrop) {
            isCenterCrop = centerCrop;
            return this;
        }

        public Builder setCircle(boolean circle) {
            isCircle = circle;
            return this;
        }

        public Builder setClearMemory(boolean clearMemory) {
            isClearMemory = clearMemory;
            return this;
        }

        public Builder setClearDiskMemory(boolean clearDiskMemory) {
            isClearDiskMemory = clearDiskMemory;
            return this;
        }

        public ImageConfigImpl build() {
            return new ImageConfigImpl(this);
        }

        public Builder cacheStrategy(@CacheStrategy.Strategy int cacheStrategy) {
            this.cacheStrategy = cacheStrategy;
            return this;
        }
    }
}
