package com.liukun.androideasymvp.helper;

import android.util.ArrayMap;

import com.liukun.androideasymvp.MyEventBusIndex;
import com.liukun.androideasymvp.commom.MessageWrap;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/**
 * Author: liukun on 2020/6/20.
 * Mail  : 3266817262@qq.com
 * Description: EventBus 工具类
 */
public class EventBusHelper {

    /**
     * EventBus 索引类
     */
    public static final SubscriberInfoIndex SUBSCRIBE_INDEX = new MyEventBusIndex();

    /**
     * 存储这个类是否需要注册
     */
    public static final ArrayMap<String, Boolean> SUBSCRIBE_EVENT = new ArrayMap<>();

    private EventBusHelper() {
    }

    /**
     * 初始化
     */
    public static void init() {
        EventBus.builder()
                .ignoreGeneratedIndex(false)
                .addIndex(SUBSCRIBE_INDEX)
                .installDefaultEventBus();
    }


    public static void register(Object subscriber) {
        if (canSubscribeEvent(subscriber)) {

            EventBus.getDefault().register(subscriber);
        }
    }

    public static void unregister(Object subscriber) {
        if (canSubscribeEvent(subscriber) && EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().unregister(subscriber);
        }
    }

    /**
     * 判断是否使用了 EventBus
     *
     * @param subscriber 被订阅的类
     * @return true 是用了注册 false 没有注册
     */
    private static boolean canSubscribeEvent(Object subscriber) {
        Class<?> clazz = subscriber.getClass();
        //这个类是否被遍历过
        Boolean result = SUBSCRIBE_EVENT.get(clazz.getName());
        if (result == null) {
            while (clazz != null) {
                //如果索引中有这个类 说明需要注册
                if (SUBSCRIBE_INDEX.getSubscriberInfo(clazz) != null) {
                    result = true;
                    clazz = null;
                } else {
                    String clazzName = clazz.getName();
                    // 忽略java和 android 开头的 类
                    if (clazzName.startsWith("java") || clazzName.startsWith("android")) {
                        clazz = null;
                    } else {
                        // 向父类查询 可看看是需要注册
                        clazz = clazz.getSuperclass();
                    }
                }
            }
            if (result == null) {
                result = false;
            }
            SUBSCRIBE_EVENT.put(subscriber.getClass().getName(), result);
        }
        return result;
    }


    public static void postMessage(MessageWrap<?> messageWrap) {
        EventBus.getDefault().post(messageWrap);
    }

    public static void postStickyMessage(MessageWrap<?> messageWrap) {

        EventBus.getDefault().postSticky(messageWrap);
    }
}
