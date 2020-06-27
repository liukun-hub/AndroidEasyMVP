package com.liukun.base.net;

import android.util.Log;

import com.liukun.base.BuildConfig;
import com.liukun.base.helper.LogUtil;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description: 一个拦截器工具类,用于日志拦截和添加头部相关信息
 */
public class InterceptorUtil {
    public static final String TAG = "okHttp";

    public static HttpLoggingInterceptor LogInterceptor() {     //日志拦截器,用于打印返回请求的结果
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            private StringBuilder mMessage = new StringBuilder();

            @Override
            public void log(String message) {
//                LogUtil.init(BuildConfig.DEBUG,TAG);
                // 请求或者响应开始
                if (message.startsWith("--> POST")) {
                    mMessage.setLength(0);
                }
                // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
                if ((message.startsWith("{") && message.endsWith("}"))
                        || (message.startsWith("[") && message.endsWith("]"))) {
                    message = JsonUtil.formatJson(JsonUtil.decodeUnicode(message));
                }
                mMessage.append(message.concat("\n"));
                // 响应结束，打印整条日志
                if (message.startsWith("<-- END HTTP")) {
                    LogUtil.d(TAG, mMessage.toString());
//                    Log.d(TAG, "log:" + mMessage.toString());
                }


            }
        });
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    public static Interceptor HeaderInterceptor() {      //头部添加请求头信息
        return new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json;charSet=UTF-8")
                        .build();

//                Set<String> paramsKeys = request.url().queryParameterNames();
//                for (String key : paramsKeys) {
//                    LogUtil.d(key + ":" + request.url().queryParameter(key));
//                }
                return chain.proceed(request);
            }
        };
    }
}
