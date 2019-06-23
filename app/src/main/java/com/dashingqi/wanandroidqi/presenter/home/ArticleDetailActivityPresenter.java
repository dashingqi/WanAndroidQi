package com.dashingqi.wanandroidqi.presenter.home;

import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.home.ArticleDetailContract;
import com.dashingqi.wanandroidqi.model.DataModel;

import javax.inject.Inject;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.presenter.home
 * @ClassName: ArticleDetailActivityPresenter
 * @Author: DashingQI
 * @CreateDate: 2019-06-23 19:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-23 19:06
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ArticleDetailActivityPresenter extends BasePresenter<ArticleDetailContract.View> implements ArticleDetailContract.Presenter {
    @Inject
    public ArticleDetailActivityPresenter(DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void collectArticle() {

    }

    @Override
    public void unCollectArticle() {

    }
}
