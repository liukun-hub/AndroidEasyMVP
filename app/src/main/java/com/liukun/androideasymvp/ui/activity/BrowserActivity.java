package com.liukun.androideasymvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.action.StatusAction;
import com.liukun.androideasymvp.commom.MyActivity;
import com.liukun.androideasymvp.helper.IntentKey;
import com.liukun.androideasymvp.mvp.base.BaseMvpActivity;
import com.liukun.androideasymvp.widget.BrowserView;
import com.liukun.androideasymvp.widget.HintLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import androidx.annotation.NonNull;
import butterknife.BindView;

/**
 * 浏览器界面
 */
public class BrowserActivity extends BaseMvpActivity implements StatusAction, OnRefreshListener {

    @BindView(R.id.pb_browser_progress)
    ProgressBar mPbBrowserProgress;
    @BindView(R.id.wv_browser_view)
    BrowserView mWvBrowserView;
    @BindView(R.id.sl_browser_refresh)
    SmartRefreshLayout mSlBrowserRefresh;
    @BindView(R.id.hl_browser_hint)
    HintLayout mHlBrowserHint;

    public static void start(Context context, String url) {
        if (url == null || "".equals(url)) {
            return;
        }
        Intent intent = new Intent(context, BrowserActivity.class);
        intent.putExtra(IntentKey.URL, url);
        context.startActivity(intent);
    }

    public static void start(Context context, String url, String title) {
        if (url == null || "".equals(url)) {
            return;
        }
        Intent intent = new Intent(context, BrowserActivity.class);
        intent.putExtra(IntentKey.URL, url);
        intent.putExtra(IntentKey.TITLE, title);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_browser;
    }

    @Override
    protected void initView() {
        // 设置网页刷新监听
        mSlBrowserRefresh.setOnRefreshListener(this);
    }

    @Override
    protected void initData() {
        showLoading();
        mWvBrowserView.setBrowserViewClient(new MyBrowserViewClient());
        mWvBrowserView.setBrowserChromeClient(new MyBrowserChromeClient(mWvBrowserView));
//        WebSettings settings = mWvBrowserView.getSettings();
//        settings.setDomStorageEnabled(true);
//        settings.setJavaScriptEnabled(true);
//        mWvBrowserView.addJavascriptInterface();
        String url = getString(IntentKey.URL);
        mWvBrowserView.loadUrl(url);
        String title = getString(IntentKey.TITLE);
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
    }

    @Override
    public HintLayout getHintLayout() {
        return mHlBrowserHint;
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }

    /**
     * 重新加载当前页
     */
    private void reload() {
        mWvBrowserView.reload();
    }

    private class MyBrowserViewClient extends BrowserView.BrowserViewClient {

        /**
         * 网页加载错误时回调，这个方法会在 onPageFinished 之前调用
         */
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            // 这里为什么要用延迟呢？因为加载出错之后会先调用 onReceivedError 再调用 onPageFinished
            post(() -> showError(v -> reload()));
        }

        /**
         * 开始加载网页
         */
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            mPbBrowserProgress.setVisibility(View.VISIBLE);
        }

        /**
         * 完成加载网页
         */
        @Override
        public void onPageFinished(WebView view, String url) {
            mPbBrowserProgress.setVisibility(View.GONE);
            mSlBrowserRefresh.finishRefresh();
            showComplete();
        }
    }

    private class MyBrowserChromeClient extends BrowserView.BrowserChromeClient {

        private MyBrowserChromeClient(BrowserView view) {
            super(view);
        }

        /**
         * 收到网页标题
         */
        @Override
        public void onReceivedTitle(WebView view, String title) {
            if (title != null) {
                setTitle(title);
            }
        }

        /**
         * 收到加载进度变化
         */
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            mPbBrowserProgress.setProgress(newProgress);
        }
    }

}