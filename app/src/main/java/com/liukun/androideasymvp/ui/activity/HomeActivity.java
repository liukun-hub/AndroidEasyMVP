package com.liukun.androideasymvp.ui.activity;

import android.view.KeyEvent;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.commom.MyFragment;
import com.liukun.androideasymvp.mvp.base.BaseMvpActivity;
import com.liukun.androideasymvp.mvp.base.BaseMvpFragment;
import com.liukun.androideasymvp.ui.frament.FragmentA;
import com.liukun.androideasymvp.ui.frament.FragmentB;
import com.liukun.androideasymvp.ui.frament.FragmentC;
import com.liukun.androideasymvp.ui.frament.FragmentD;
import com.liukun.base.BaseFragmentAdapter;
import com.liukun.base.helper.ActivityStackManager;
import com.liukun.base.helper.DoubleClickHelper;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 *
 *    主页界面
 */
public final class HomeActivity extends BaseMvpActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.vp_home_pager)
    ViewPager mViewPager;
    @BindView(R.id.bv_home_navigation)
    BottomNavigationView mBottomNavigationView;

    public BaseFragmentAdapter<BaseMvpFragment> mPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        // 不使用图标默认变色
        mBottomNavigationView.setItemIconTintList(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    protected void initData() {
        mPagerAdapter = new BaseFragmentAdapter<>(this);
        mPagerAdapter.addFragment(FragmentA.newInstance());
        mPagerAdapter.addFragment(FragmentB.newInstance());
        mPagerAdapter.addFragment(FragmentC.newInstance());
        mPagerAdapter.addFragment(FragmentD.newInstance());

        mViewPager.setAdapter(mPagerAdapter);

        // 限制页面数量
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());

    }

    /**
     * {@link BottomNavigationView.OnNavigationItemSelectedListener}
     */

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                mPagerAdapter.setCurrentItem(FragmentA.class);
                return true;
            case R.id.home_found:
                mPagerAdapter.setCurrentItem(FragmentB.class);
                return true;
            case R.id.home_message:
                mPagerAdapter.setCurrentItem(FragmentC.class);
                return true;
            case R.id.home_me:
                mPagerAdapter.setCurrentItem(FragmentD.class);
                return true;
            default:
                break;
        }
        return false;
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 回调当前 Fragment 的 onKeyDown 方法
        if (mPagerAdapter.getCurrentFragment().onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (DoubleClickHelper.isOnDoubleClick()) {
            // 移动到上一个任务栈，避免侧滑引起的不良反应
            moveTaskToBack(false);
            postDelayed(() -> {

                // 进行内存优化，销毁掉所有的界面
                ActivityStackManager.getInstance().finishAllActivities();
                // 销毁进程（注意：调用此 API 可能导致当前 Activity onDestroy 方法无法正常回调）
                // System.exit(0);

            }, 300);
        } else {
            toast(R.string.home_exit_hint);
        }
    }

    @Override
    protected void onDestroy() {
        mViewPager.setAdapter(null);
        mBottomNavigationView.setOnNavigationItemSelectedListener(null);
        super.onDestroy();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                mBottomNavigationView.setSelectedItemId(R.id.menu_home);
                break;
            case 1:
                mBottomNavigationView.setSelectedItemId(R.id.home_found);
                break;
            case 2:
                mBottomNavigationView.setSelectedItemId(R.id.home_message);
                break;
            case 3:
                mBottomNavigationView.setSelectedItemId(R.id.home_me);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}