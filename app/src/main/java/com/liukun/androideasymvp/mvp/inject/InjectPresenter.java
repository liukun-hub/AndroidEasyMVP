package com.liukun.androideasymvp.mvp.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: liukun on 2020/6/26.
 * Mail  : 3266817262@qq.com
 * Description: 解决View层一对多个Presenter情况
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectPresenter {

}
