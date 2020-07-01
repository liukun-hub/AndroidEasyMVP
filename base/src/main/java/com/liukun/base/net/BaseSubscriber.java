package com.liukun.base.net;

import android.accounts.NetworkErrorException;
import android.content.Context;

import com.google.gson.JsonParseException;

import org.json.JSONException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.concurrent.TimeoutException;

import io.reactivex.ObservableEmitter;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description:主要是请求成功失败、网络异常时的回调,它实现的Observer类,其中成功失败主要在Onext方法里处理
 */
public abstract class BaseSubscriber<T> implements Subscriber<T> {
//    private Context mContext;



    public BaseSubscriber(Context mContext) {
//        this.mContext = mContext;
    }

    public BaseSubscriber() {
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        String message;
        if (e instanceof ConnectException ||
                e instanceof TimeoutException ||
                e instanceof NetworkErrorException ||
                e instanceof UnknownHostException) {
            message = e.getMessage();
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            message = "数据异常";            //均视为解析错误
        } else if (e instanceof SocketTimeoutException) {
            message = "网络不给力~请稍后重试";  //均视为网络错误
        } else {
            message = e.getMessage();
        }
        onFailure(e, message);
    }

    @Override
    public void onNext(T t) {
//        if (baseResponse.isSuccess()) {
//            onSuccess(baseResponse);
//        } else {
//            onCodeError(baseResponse);
//        }
        onSuccess(t);
    }

    //请求成功且返回码为200的回调方法,这里抽象方法申明
    public abstract void onSuccess(T t) ;
//
//    //请求成功但返回的code码不是200的回调方法,这里抽象方法申明
//    public abstract void onCodeError(BaseResponse baseResponse);

    //请求失败回调方法,这里抽象方法申明
    public abstract void onFailure(Throwable e,String message) ;
}