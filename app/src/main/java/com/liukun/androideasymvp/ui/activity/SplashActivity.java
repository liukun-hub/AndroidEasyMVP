package com.liukun.androideasymvp.ui.activity;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.util.Log;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.mvp.base.BaseMvpActivity;

import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;

/**
 * Author: liukun on 2020/6/9.
 * Mail  : 3266817262@qq.com
 * Description: APP 引导页
 */
public class SplashActivity extends BaseMvpActivity {
    @BindView(R.id.iv_splash_lottie)
    LottieAnimationView mIvSplashLottie;
    @BindView(R.id.iv_splash_name)
    AppCompatTextView mIvSplashName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    protected void initView() {
        super.initView();
        hideBottomUIMenu();
        // 设置动画监听
        mIvSplashLottie.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(HomeActivity.class);
                finish();
            }
        });
    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    public void hideBottomUIMenu() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {// lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

    }

    @Override
    protected void initData() {
        //获取用户数据
    }

    @Override
    public ImmersionBar createStatusBarConfig() {
        return super.createStatusBarConfig()
                // 有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
                .fullScreen(true)
                // 隐藏状态栏
                .hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
                // 透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
                .transparentNavigationBar();
    }

    @Override
    public void onBackPressed() {
        //禁用返回键
        //super.onBackPressed();
    }

}
