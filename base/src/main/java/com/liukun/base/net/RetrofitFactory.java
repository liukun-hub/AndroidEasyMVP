package com.liukun.base.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description: 主要获取okhttp、retrofit的实例,然后再通过retrofit的实例获取ApiService的实例
 */
public class RetrofitFactory {
    //初始化Okhttp,绑定拦截器事件
    OkHttpClient client = new OkHttpClient.Builder().
            connectTimeout(20, TimeUnit.SECONDS).                   //设置请求超时时间
            readTimeout(20, TimeUnit.SECONDS).                       //设置读取数据超时时间
            writeTimeout(20, TimeUnit.SECONDS).//设置写入数据超时时间
            addInterceptor(InterceptorUtil.LogInterceptor()).                //绑定日志拦截器
            addNetworkInterceptor(InterceptorUtil.HeaderInterceptor())       //绑定header拦截器
            .build();

    Retrofit retrofit;


    public static RetrofitFactory instance;
//    public ApiService apiService = retrofit.create(ApiService.class);         //通过retrofit的实例,获取ApiServise接口的实例

    private RetrofitFactory() {

    }

    public void init(String baseUrl) {
        retrofit = new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create()).             //设置gson转换器,将返回的json数据转为实体
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).       //设置CallAdapter
                baseUrl(baseUrl).
                client(client)                                                  //设置客户端okhttp相关参数
                .build();

    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }

    public static RetrofitFactory getInstance() {
        if (instance == null) {
            synchronized (RetrofitFactory.class) {
                if (instance == null) {
                    instance = new RetrofitFactory();
                }
            }
        }
        return instance;
    }

//    public ApiService getApiService() {
//        return apiService;
//    }
}