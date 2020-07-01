package com.liukun.base.net.imageloader;

import android.content.Context;

import androidx.annotation.NonNull;

/**
 * Author: liukun on 2020/6/27.
 * Mail  : 3266817262@qq.com
 * Description: 图片加载策略
 */
public interface IBaseImageStrategy<T extends ImageConfig> {

    /**
     * 加载图片
     *
     * @param context {@link Context}
     * @param config  图片加载的配置信息 必须实现 {@link ImageConfig}
     */
    void loadImage(@NonNull Context context, @NonNull T config);

    /**
     * 停止加载图片
     *
     * @param context {@link Context}
     * @param config  图片记载的配置信息 必须实现 {@link ImageConfig}
     */
    void clear(@NonNull Context context, @NonNull T config);

}
