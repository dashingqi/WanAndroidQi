package com.dashingqi.wanandroidqi.presenter.wechat;

import android.util.Log;

import com.dashingqi.wanandroidqi.base.Observer.BaseObserver;
import com.dashingqi.wanandroidqi.base.presenter.BasePresenter;
import com.dashingqi.wanandroidqi.contract.wechat.WeChatArticlesListContract;
import com.dashingqi.wanandroidqi.model.DataModel;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;
import com.dashingqi.wanandroidqi.utils.RxUtil;

import javax.inject.Inject;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.presenter.wechat
 * @ClassName: WeChatArticlesListPresenter
 * @Author: DashingQI
 * @CreateDate: 2019-06-19 21:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-19 21:21
 * @UpdateRemark:
 * @Version: 1.0
 */
public class WeChatArticlesListPresenter extends BasePresenter<WeChatArticlesListContract.View> implements WeChatArticlesListContract.Presenter {
    private static final String TAG = "WeChatArticlesListPrese";

    @Inject
    public WeChatArticlesListPresenter(DataModel dataModel) {
        super(dataModel);
    }

    @Override
    public void getArticlesListData(int id,int pageNum) {

        addRxSubScribe(
                mModel.getWeChatArticlesListData(id,pageNum)
                .compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .subscribeWith(new BaseObserver<ArticlesBean>(mView,false,false){
                    @Override
                    public void onNext(ArticlesBean articlesBean) {
                        Log.d(TAG, "onNext: size = "+articlesBean.getDatas().size());
                        mView.showArticlesListData(articlesBean);

                    }
                })
        );

    }

    @Override
    public void getLoadMoreArticleListData(int id, int pageNum) {
        addRxSubScribe(
                mModel.getWeChatArticlesListData(id,pageNum)
                        .compose(RxUtil.rxSchedulerHelper())
                        .compose(RxUtil.handleResult())
                        .subscribeWith(new BaseObserver<ArticlesBean>(mView,false,false){
                            @Override
                            public void onNext(ArticlesBean articlesBean) {
                                Log.d(TAG, "onNext: size = "+articlesBean.getDatas().size());
                                mView.showMoreArticlesListData(articlesBean);

                            }
                        })
        );
    }
}
