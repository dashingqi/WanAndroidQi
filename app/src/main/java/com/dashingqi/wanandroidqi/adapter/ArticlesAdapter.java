package com.dashingqi.wanandroidqi.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.network.entity.home.ArticleBean;

import java.util.List;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.adapter
 * @ClassName: ArticlesAdapter
 * @Author: DashingQI
 * @CreateDate: 2019-06-13 20:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-13 20:41
 * @UpdateRemark: 首页文章列表适配器
 * @Version: 1.0
 */
public class ArticlesAdapter extends BaseQuickAdapter<ArticleBean, BaseViewHolder> {
    public ArticlesAdapter(int layoutResId, List<ArticleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleBean item) {
        if (item == null) return;
        helper.setText(R.id.mTvAuthorArticleItem, item.getAuthor())
                .setText(R.id.mTvDateArticleItem, item.getNiceDate())
                .setText(R.id.mTvTitleArticleItem, item.getTitle())
                .setText(R.id.mTvTypeArticleItem, item.getSuperChapterName())
                .addOnClickListener(R.id.mIvArticleCollect);

    }
}
