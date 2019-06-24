package com.dashingqi.wanandroidqi.contract.system;

        import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
        import com.dashingqi.wanandroidqi.base.view.BaseView;
        import com.dashingqi.wanandroidqi.network.entity.home.ArticleBean;
        import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;

public interface SystemArticleListContract {
    interface View extends BaseView {
        void showArticleListData(ArticlesBean data);

        void showLoadMoreArticle(ArticlesBean data);
    }

    interface Presenter extends IPresenter<View> {
        void getArticlesList(int pageNum, int cid);

        void getMoreArticleDataList(int pageNum, int cid);
    }
}
