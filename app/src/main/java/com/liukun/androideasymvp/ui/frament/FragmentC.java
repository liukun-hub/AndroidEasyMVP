package com.liukun.androideasymvp.ui.frament;

import com.hjq.toast.ToastUtils;
import com.liukun.androideasymvp.R;
import com.liukun.androideasymvp.commom.BaseAdapter;
import com.liukun.androideasymvp.commom.ViewHolder;
import com.liukun.androideasymvp.mvp.base.BaseMvpFragment;
import com.liukun.androideasymvp.mvp.contract.ArticleListContract;
import com.liukun.androideasymvp.mvp.inject.InjectPresenter;
import com.liukun.androideasymvp.mvp.presenter.ArticleListPresenter;
import com.liukun.androideasymvp.ui.bean.ArticleListBean;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 *
 */
public final class FragmentC extends BaseMvpFragment implements ArticleListContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @InjectPresenter
    ArticleListPresenter mArticleListPresenter;

    BaseAdapter<ArticleListBean.DatasEntity> mBaseAdapter;

    public static FragmentC newInstance() {
        return new FragmentC();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_c;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        mBaseAdapter = new BaseAdapter<ArticleListBean.DatasEntity>(R.layout.fragment_b, null, true) {
            @Override
            public void bind(ViewHolder holder, ArticleListBean.DatasEntity item) {
                holder.setText(R.id.text, item.getChapterName());
            }
        };
        mRecyclerView.setAdapter(mBaseAdapter);
        mArticleListPresenter.getArticleList(1);

    }

    @Override
    public void getListDataSucceed(ArticleListBean listBean) {
        mBaseAdapter.setNewInstance(listBean.getDatas());
    }

    @Override
    public void getListDataFail(String message) {
        ToastUtils.show(message);
    }
}