package com.dashingqi.wanandroidqi.contract.wechat;

import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.base.view.BaseView;
import com.dashingqi.wanandroidqi.network.entity.home.ArticlesBean;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.contract.wechat
 * @ClassName: WeChatArticlesListContract
 * @Author: DashingQI
 * @CreateDate: 2019-06-19 21:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-19 21:22
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface WeChatArticlesListContract {

    interface View extends BaseView{

        void showArticlesListData(ArticlesBean data);
    }

    interface Presenter extends IPresenter<View>{
        void getArticlesListData(int id,int pageNum);
    }


}
