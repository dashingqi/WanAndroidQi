package com.dashingqi.wanandroidqi.presenter.system;

import com.dashingqi.wanandroidqi.base.Observer.BaseObserver;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.system.SystemArticleListContract;
import com.dashingqi.wanandroidqi.model.DataModel;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.utils.RxUtil;

import javax.inject.Inject;

public class SystemArticleListPresenter extends BasePresenter<SystemArticleListContract.View> implements SystemArticleListContract.Presenter {
    @Inject
    public SystemArticleListPresenter(DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void getArticlesList(int pageNum, int cid) {
        addRxSubScribe(
                mModel.getArticlesListData(pageNum, cid)
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<ArticlesBean>(mView, false, false) {
                            @Override
                            public void onNext(ArticlesBean articlesBean) {
                                super.onNext(articlesBean);
                                mView.showArticleListData(articlesBean);
                            }
                        })
        );

    }

    @Override
    public void getMoreArticleDataList(int pageNum, int cid) {
        addRxSubScribe(
                mModel.getArticlesListData(pageNum, cid)
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<ArticlesBean>(mView, false, false) {
                            @Override
                            public void onNext(ArticlesBean articlesBean) {
                                super.onNext(articlesBean);
                                mView.showLoadMoreArticle(articlesBean);
                            }
                        })
        );
    }
}
