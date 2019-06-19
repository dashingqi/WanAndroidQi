package com.dashingqi.wanandroidqi.view.wechat;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.adapter.ArticlesAdapter;
import com.dashingqi.wanandroidqi.base.fragment.BaseLoadingFragment;
import com.dashingqi.wanandroidqi.common.Constant;
import com.dashingqi.wanandroidqi.common.IntentParams;
import com.dashingqi.wanandroidqi.contract.wechat.WeChatArticlesListContract;
import com.dashingqi.wanandroidqi.di.module.wechat.WeChatArticleListModule;
import com.dashingqi.wanandroidqi.network.entity.home.ArticleBean;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.presenter.wechat.WeChatArticlesListPresenter;
import com.dashingqi.wanandroidqi.view.MainActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.view.wechat
 * @ClassName: WeChatArticlesListFragment
 * @Author: DashingQI
 * @CreateDate: 2019-06-19 21:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-19 21:20
 * @UpdateRemark:
 * @Version: 1.0
 */
public class WeChatArticlesListFragment extends BaseLoadingFragment<WeChatArticlesListPresenter> implements WeChatArticlesListContract.View {

    @Inject
    WeChatArticlesListPresenter mWeChatArticlesListPresenter;

    @Inject
    @Named("WxArticlesLinearManager")
    LinearLayoutManager mLinearLayoutManager;

    @Inject
    @Named("WxArticleList")
    List<ArticleBean> mArticleList;

    @BindView(R.id.mRecyclerView)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.mSmartRefreshLayout)
    protected SmartRefreshLayout mSmartRefreshLayout;


    private int id;
    private int pageNum = 1;
    private ArticlesAdapter articlesAdapter;
    private boolean isRefresh = false;

    @Override
    public WeChatArticlesListPresenter getPresenter() {
        return mWeChatArticlesListPresenter;
    }

    @Override
    protected void initView() {
        super.initView();
        initRecyclerView();
        initSmartRefreshLayout();
        getData();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {
        mWeChatArticlesListPresenter.getArticlesListData(id, pageNum);

    }

    @Override
    protected void inject() {
        ((MainActivity) mActivity)
                .getComponent()
                .getWeChatArticlesListComponent(new WeChatArticleListModule())
                .inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_common_artiles_list;
    }

    @Override
    public void showArticlesListData(ArticlesBean data) {

        for (ArticleBean articleBean : data.getDatas()) {
            mArticleList.add(articleBean);
        }

        articlesAdapter.notifyDataSetChanged();


    }

    @Override
    public void showMoreArticlesListData(ArticlesBean data) {
        if (isRefresh) {
            if (mArticleList != null && mArticleList.size() > 0) {
                mArticleList.clear();
            }

            mSmartRefreshLayout.finishRefresh();
        } else {
            if (mArticleList == null || mArticleList.size() == 0) {
                mSmartRefreshLayout.finishLoadMoreWithNoMoreData();
            } else {
                mSmartRefreshLayout.finishLoadMore(true);
            }
        }

        mArticleList.addAll(data.getDatas());
        articlesAdapter.notifyDataSetChanged();

    }

    public static WeChatArticlesListFragment newInstance(int id) {
        WeChatArticlesListFragment weChatArticlesListFragment = new WeChatArticlesListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IntentParams.WXARTICLESID, id);
        weChatArticlesListFragment.setArguments(bundle);
        return weChatArticlesListFragment;
    }

    /**
     * 获取到微信公众号的Id
     */
    private void getData() {
        Bundle arguments = getArguments();
        if (arguments != null)
            id = arguments.getInt(IntentParams.WXARTICLESID, -1);
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        articlesAdapter = new ArticlesAdapter(R.layout.item_article_list, mArticleList);
        mRecyclerView.setAdapter(articlesAdapter);
    }

    private void initSmartRefreshLayout() {
        //下拉刷新事件
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageNum = 1;
                isRefresh = true;
                mWeChatArticlesListPresenter.getLoadMoreArticleListData(id, pageNum);

            }
        });

        //上滑加载事件
        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pageNum++;
                isRefresh = false;
                mWeChatArticlesListPresenter.getLoadMoreArticleListData(id, pageNum);
            }
        });
    }
}
