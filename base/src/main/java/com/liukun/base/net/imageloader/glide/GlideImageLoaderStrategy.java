package com.liukun.base.net.imageloader.glide;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.liukun.base.net.imageloader.IBaseImageStrategy;

import androidx.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: liukun on 2020/6/27.
 * Mail  : 3266817262@qq.com
 * Description: 此处提供一个默认的Glide的图片加载策略
 */
public class GlideImageLoaderStrategy implements IBaseImageStrategy<ImageConfigImpl> {
    @Override
    public void loadImage(@NonNull Context context, @NonNull ImageConfigImpl config) {
        RequestOptions options = new RequestOptions();
        switch (config.getCacheStrategy()) {
            //缓存策略
            case CacheStrategy.NONE:
                options.diskCacheStrategy(DiskCacheStrategy.NONE);
                break;
            case CacheStrategy.RESOURCE:
                options.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
                break;
            case CacheStrategy.DATA:
                options.diskCacheStrategy(DiskCacheStrategy.DATA);
                break;
            case CacheStrategy.AUTOMATIC:
                options.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
                break;
            default:
                options.diskCacheStrategy(DiskCacheStrategy.ALL);
                break;
        }
//        if (config.isCrossFade()) {
//            options.transition(DrawableTransitionOptions.withCrossFade());
//        }

        if (config.isCenterCrop()) {
            options.centerCrop();
        }

        if (config.isCircle()) {
            options.circleCrop();
        }

        if (config.isImageRadius()) {
            options.transform(new RoundedCorners(config.getImageRadius()));
        }

        if (config.isBlurImage()) {
            options.transform(new BlurTransformation(config.getBlurValue()));
        }

//        if (config.getTransformation() != null) {//glide用它来改变图形的形状
//            glideRequest.transform(config.getTransformation());
//        }

        if (config.getPlaceholder() != 0)//设置占位符
        {
            options.placeholder(config.getPlaceholder());
        }

        if (config.getErrorPic() != 0)//设置错误的图片
        {
            options.error(config.getErrorPic());
        }

        if (config.getFallBack() != 0)//设置请求 url 为空图片
        {
            options.fallback(config.getFallBack());
        }
        Glide.with(context)
                .load(config.getUrl())
                .apply(options)
                .into(config.getImageView());

    }

    @Override
    public void clear(@NonNull Context context, @NonNull ImageConfigImpl config) {
        if (config.getImageView() != null) {
            Glide.with(context).clear(config.getImageView());
        }
        if (config.getImageViews() != null && config.getImageViews().length > 0) {//取消在执行的任务并且释放资源
            for (ImageView imageView : config.getImageViews()) {
                Glide.with(context).clear(imageView);
            }
        }

        //清除本地缓存
        if (config.isClearDiskCache()) {
            Completable.fromAction(new Action() {
                @Override
                public void run() throws Exception {
                    Glide.get(context).clearDiskCache();
                }
            }).subscribeOn(Schedulers.io()).subscribe();

        }

        //清除内存缓存
        if (config.isClearMemory()) {
            Completable.fromAction(new Action() {
                @Override
                public void run() throws Exception {
                    Glide.get(context).clearMemory();
                }
            }).subscribeOn(Schedulers.io()).subscribe();
        }
    }
}
