package com.dashingqi.wanandroidqi.contract.home;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.contract.home
 * @ClassName: ArticleDetailContract
 * @Author: DashingQI
 * @CreateDate: 2019-06-23 19:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-23 19:07
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface ArticleDetailContract {

    interface View extends BaseView {
        //收藏文章成功
        void shoeCollectArticleSuccess();

        //取消收藏
        void showUnCollectArticleSuccess();
    }

    interface Presenter extends IPresenter<View> {

        //收藏文章
        void collectArticle();

        //取消收藏
        void unCollectArticle();
    }
}
