package com.liukun.androideasymvp.mvp.model;


import com.liukun.androideasymvp.mvp.base.BaseModel;
import com.liukun.androideasymvp.mvp.contract.ArticleListContract;
import com.liukun.androideasymvp.net.ApiService;
import com.liukun.androideasymvp.ui.bean.ArticleListBean;
import com.liukun.base.net.BaseResponse;
import com.liukun.base.net.RetrofitFactory;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: liukun on 2020/6/26.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class ArticleListModel extends BaseModel implements ArticleListContract.ArticleListModel {

    @Override
    public Observable<BaseResponse<ArticleListBean>> getArticleList(int page) {

        return RetrofitFactory.getInstance()
                .create(ApiService.class)
                .getArticleList(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
