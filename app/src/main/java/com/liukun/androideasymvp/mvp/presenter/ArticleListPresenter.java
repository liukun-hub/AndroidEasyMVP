package com.liukun.androideasymvp.mvp.presenter;

import android.util.Log;

import com.liukun.androideasymvp.mvp.base.BasePresenter;
import com.liukun.androideasymvp.mvp.contract.ArticleListContract;
import com.liukun.androideasymvp.mvp.model.ArticleListModel;
import com.liukun.androideasymvp.ui.bean.ArticleListBean;
import com.liukun.base.net.BaseResponse;
import com.liukun.base.net.BaseSubscriber;

/**
 * Author: liukun on 2020/6/26.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class ArticleListPresenter extends BasePresenter<ArticleListModel,
        ArticleListContract.View> implements ArticleListContract.Presenter {


    @Override
    public void getArticleList(int page) {
        getModel().getArticleList(page).subscribe(new BaseSubscriber<BaseResponse<ArticleListBean>>() {
            @Override
            public void onStart() {
                super.onStart();
                getView().showLoading();
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                getView().hideLoading();
            }

            @Override
            public void onSuccess(BaseResponse<ArticleListBean> articleListBeanBaseResponse) {
                getView().getListDataSucceed(articleListBeanBaseResponse.getData());
            }

            @Override
            public void onCodeError(BaseResponse baseResponse) {

            }

            @Override
            public void onFailure(Throwable e, String message) {
                getView().getListDataFail(message);
            }
        });

    }
}
