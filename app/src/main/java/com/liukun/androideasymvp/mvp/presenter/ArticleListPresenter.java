package com.liukun.androideasymvp.mvp.presenter;

import android.util.Log;

import com.liukun.androideasymvp.mvp.base.BasePresenter;
import com.liukun.androideasymvp.mvp.contract.ArticleListContract;
import com.liukun.androideasymvp.mvp.model.ArticleListModel;
import com.liukun.androideasymvp.net.ApiService;
import com.liukun.androideasymvp.ui.bean.ArticleListBean;
import com.liukun.base.net.BaseObserver;
import com.liukun.base.net.BaseResponse;
import com.liukun.base.net.BaseSubscriber;
import com.liukun.base.net.RetrofitFactory;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import retrofit2.Response;

/**
 * Author: liukun on 2020/6/26.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class ArticleListPresenter extends BasePresenter<ArticleListModel,
        ArticleListContract.View> implements ArticleListContract.Presenter {


    @Override
    public void getArticleList(int page) {
        getModel().getArticleList(page).subscribe(new BaseObserver<ArticleListBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                super.onSubscribe(d);
                getView().showLoading();
            }

            @Override
            public void onComplete() {
                super.onComplete();
                getView().hideLoading();
            }

            @Override
            public void onSuccess(BaseResponse<ArticleListBean> baseResponse) {
                getView().getListDataSucceed(baseResponse.getData());
            }

            @Override
            public void onFailure(Throwable e, boolean netWork) throws Exception {
                getView().getListDataFail(e.getMessage());
            }
        });

    }
}
