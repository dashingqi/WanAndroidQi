package com.dashingqi.wanandroidqi.view.system;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.ArticlesAdapter;
import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.common.IntentParams;
import com.dashingqi.wanandroidqi.contract.system.SystemArticleListContract;
import com.dashingqi.wanandroidqi.di.component.fragment.system.DaggerSystemArticleListComponent;
import com.dashingqi.wanandroidqi.network.entity.home.ArticleBean;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.presenter.system.SystemArticleListPresenter;
import com.dashingqi.wanandroidqi.view.ArticleDetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class SystemArticleFragment extends BaseLoadingFragment<SystemArticleListPresenter> implements SystemArticleListContract.View {

    @Inject
    SystemArticleListPresenter mSystemArticleListPresenter;

    @Inject
    List<ArticleBean> mArticleBeanList;

    @Inject
    ArticlesAdapter mArticlesAdapter;

    @Inject
    LinearLayoutManager mLinearLayoutManager;

    @BindView(R.id.mRecyclerView)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.mSmartRefreshLayout)
    protected SmartRefreshLayout mSmartRefreshLayout;

    private int mPageNum = 0;
    private boolean isRefresh = false;
    private int cid;

    @Override
    protected void initView() {
        super.initView();
        getData();
        initRecyclerView();
        initSmartRefreshLayout();
    }

    private void initSmartRefreshLayout() {
        //下拉刷新事件
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPageNum = 0;
                //触发了下拉刷新的事件
                isRefresh = true;
                mSystemArticleListPresenter.getMoreArticleDataList(mPageNum, cid);
            }
        });

        //上滑加载事件
        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mPageNum++;
                isRefresh = false;
                mSystemArticleListPresenter.getMoreArticleDataList(mPageNum, cid);
            }
        });
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mArticlesAdapter);

        mArticlesAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ArticleDetailActivity.startActivityForResultByFragment(mActivity, SystemArticleFragment.this,
                        mArticleBeanList.get(position).getTitle(),
                        mArticleBeanList.get(position).getLink(),
                        IntentParams.REQUEST_ARTICLE_DETAIL_ACTIVITY);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {
        mSystemArticleListPresenter.getArticlesList(mPageNum, cid);
    }

    @Override
    protected void inject() {
        DaggerSystemArticleListComponent.builder()
                .appComponent(ApplicationQi.getAppComponent())
                .build().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_common_artiles_list;
    }

    @Override
    public SystemArticleListPresenter getPresenter() {
        return mSystemArticleListPresenter;
    }

    @Override
    public void showArticleListData(ArticlesBean data) {

        for (ArticleBean articleBean : data.getDatas()) {
            mArticleBeanList.add(articleBean);
        }

        mArticlesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoadMoreArticle(ArticlesBean data) {
        //展示加载更多数据
        if (isRefresh) {
            //是下拉刷新的操作
            if (mArticleBeanList != null && mArticleBeanList.size() > 0) {
                mArticleBeanList.clear();
            }
            for (ArticleBean mData : data.getDatas()) {
                mArticleBeanList.add(mData);
            }
            mSmartRefreshLayout.finishRefresh();
        } else {
            if (data == null) {
                mSmartRefreshLayout.finishLoadMoreWithNoMoreData();
            } else {
                for (ArticleBean mData : data.getDatas()) {
                    mArticleBeanList.add(mData);
                }

                mSmartRefreshLayout.finishLoadMore();
            }
        }

        mArticlesAdapter.notifyDataSetChanged();

    }

    /**
     * @param cid 文章Id
     * @return
     */
    public static SystemArticleFragment newInstance(int cid) {
        SystemArticleFragment systemArticleFragment = new SystemArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IntentParams.WXARTICLESID, cid);
        systemArticleFragment.setArguments(bundle);
        return systemArticleFragment;
    }

    /**
     * 获取到数据
     */
    private void getData() {
        Bundle bundle = getArguments();
        if (bundle != null)
            cid = bundle.getInt(IntentParams.WXARTICLESID);
    }
}
