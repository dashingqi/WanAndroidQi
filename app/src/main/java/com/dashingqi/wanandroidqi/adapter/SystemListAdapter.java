package com.dashingqi.wanandroidqi.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.network.entity.system.SystemChildrenDataBean;
import com.dashingqi.wanandroidqi.network.entity.system.SystemDataBean;

import java.util.List;

public class SystemListAdapter extends BaseQuickAdapter<SystemDataBean, BaseViewHolder> {

    public SystemListAdapter(int layoutResId, @Nullable List<SystemDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SystemDataBean item) {
        if (item == null) return;
        String details = "";
        List<SystemChildrenDataBean> childrenData = item.getChildren();
        for (SystemChildrenDataBean childrenBean : childrenData) {
            details += childrenBean.getName() + " ";
        }
        helper.setText(R.id.mTvSystemCategory, item.getName())
                .setText(R.id.mTvCategoryDetails, details);
    }
}
