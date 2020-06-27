package com.liukun.androideasymvp.mvp.contract;


import com.liukun.androideasymvp.mvp.base.IBaseView;
import com.liukun.androideasymvp.ui.bean.ArticleListBean;
import com.liukun.base.net.BaseResponse;

import rx.Observable;

/**
 * Author: liukun on 2020/6/26.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public interface ArticleListContract {

    public interface ArticleListModel {

        Observable<BaseResponse<ArticleListBean>> getArticleList(int page);
    }

    public interface View extends IBaseView {
        void getListDataSucceed(ArticleListBean listBean);

        void getListDataFail(String message);
    }

    public interface Presenter {
        void getArticleList(int page);
    }

}
