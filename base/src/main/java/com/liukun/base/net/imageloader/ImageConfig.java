package com.liukun.base.net.imageloader;

import android.widget.ImageView;

/**
 * Author: liukun on 2020/6/27.
 * Mail  : 3266817262@qq.com
 * Description: 图片配置信息加载的基类，存放基本参数
 */
public class ImageConfig {
    protected String url;
    protected ImageView imageView;
    protected int placeholder;
    protected int errorPic;

    public String getUrl() {
        return url;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getPlaceholder() {
        return placeholder;
    }

    public int getErrorPic() {
        return errorPic;
    }
}
