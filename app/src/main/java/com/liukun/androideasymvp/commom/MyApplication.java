package com.liukun.androideasymvp.commom;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Toast;

import com.hjq.bar.TitleBar;
import com.hjq.bar.style.TitleBarLightStyle;
import com.hjq.toast.ToastInterceptor;
import com.hjq.toast.ToastUtils;
import com.liukun.androideasymvp.BuildConfig;
import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.helper.EventBusHelper;
import com.liukun.androideasymvp.net.ApiService;
import com.liukun.base.helper.ActivityStackManager;
import com.liukun.base.helper.LogUtil;
import com.liukun.base.net.RetrofitFactory;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.tencent.mmkv.MMKV;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class MyApplication extends Application {

    private static Context context;

    public static Context getMyApplicationContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        initSDK(this);

    }

    /**
     * 初始化一些第三方框架
     */
    public static void initSDK(Application application) {
        // 友盟统计、登录、分享 SDK
//        UmengClient.init(application);

        //日志工具
        LogUtil.init(true, "logUntil");

        //设置初始url
        RetrofitFactory.getInstance().init(ApiService.HOST);

        MMKV.initialize(application);
        // 吐司工具类
        ToastUtils.init(application);

        // 设置 Toast 拦截器
        ToastUtils.setToastInterceptor(new ToastInterceptor() {
            @Override
            public boolean intercept(Toast toast, CharSequence text) {
                boolean intercept = super.intercept(toast, text);
                if (intercept) {
                    Log.e("Toast", "空 Toast");
                } else {
                    Log.i("Toast", text.toString());
                }
                return intercept;
            }
        });

        // 标题栏全局样式
        TitleBar.initStyle(new TitleBarLightStyle(application) {

            @Override
            public Drawable getBackground() {
                return new ColorDrawable(getColor(R.color.colorPrimary));
            }

            @Override
            public Drawable getBackIcon() {
                return getDrawable(R.drawable.ic_back_black);
            }
        });

        //初始化 EventBus
        EventBusHelper.init();

        // 设置全局的 Header 构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new ClassicsHeader(context).setEnableLastTime(false));
        // 设置全局的 Footer 构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new ClassicsFooter(context).setDrawableSize(20));

        // Activity 栈管理初始化
        ActivityStackManager.getInstance().init(application);


//        // Bugly 异常捕捉
//        CrashReport.initCrashReport(application, AppConfig.getBuglyId(), false);
//
//        // Crash 捕捉界面
//        CaocConfig.Builder.create()
//                .backgroundMode(CaocConfig.BACKGROUND_MODE_SHOW_CUSTOM)
//                .enabled(true)
//                .trackActivities(true)
//                .minTimeBetweenCrashesMs(2000)
//                // 重启的 Activity
//                .restartActivity(HomeActivity.class)
//                // 错误的 Activity
//                .errorActivity(CrashActivity.class)
//                // 设置监听器
//                //.eventListener(new YourCustomEventListener())
//                .apply();

//
//        // Activity 侧滑返回
//        SmartSwipeBack.activitySlidingBack(application, activity -> {
//            if (activity instanceof SwipeAction) {
//                return ((SwipeAction) activity).isSwipeEnable();
//            }
//            return true;
//        });

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // 使用 Dex分包
        //MultiDex.install(this);
    }
}
