package com.dashingqi.wanandroidqi.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.network.entity.project.ProjectListItemBean;
import com.dashingqi.wanandroidqi.utils.image.ImagesLoader;

import java.util.List;


public class ProjectListAdapter extends BaseQuickAdapter<ProjectListItemBean, BaseViewHolder> {

    public ProjectListAdapter(int layoutResId, @Nullable List<ProjectListItemBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectListItemBean item) {
        helper.setText(R.id.mProjectTitleTv, item.getTitle())
                .setText(R.id.mProjectAuthorTv, item.getAuthor())
                .setText(R.id.mProjectTimeTv, item.getNiceDate())
                .setText(R.id.mProjectDescTv, item.getDesc())
                .addOnClickListener(R.id.mProjectLoveIv);
        ImagesLoader.loadImage(mContext, item.getEnvelopePic(), helper.getView(R.id.mProjectIv));

    }
}
