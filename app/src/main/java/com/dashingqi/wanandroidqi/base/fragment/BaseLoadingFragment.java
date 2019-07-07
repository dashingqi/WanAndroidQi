package com.dashingqi.wanandroidqi.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.base.presenter.IPresenter;
import com.dashingqi.wanandroidqi.common.Constant;
import com.dashingqi.wanandroidqi.utils.Utils;
import com.dashingqi.wanandroidqi.widget.LoadingTextView;
import com.dashingqi.wanandroidqi.widget.Titanic;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.fragment
 * @ClassName: BaseLoadingFragment
 * @Author: DashingQI
 * @CreateDate: 2019-05-30 21:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-30 21:48
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseLoadingFragment<P extends IPresenter> extends BasePresenterFragment<P> {
    private static final String TAG = "BaseLoadingFragment";

    private ViewGroup mNormalView;
    private View mLoadingView;
    private LoadingTextView mLoadingViewText;
    private Titanic mTitanic;
    private int mViewState = Constant.NORMAL_VIEW_STATE;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getView() == null) return;
        mNormalView = view.findViewById(R.id.mNormalView);

        if (mNormalView == null) {
            throw new IllegalStateException("The subclass of BaseLoadingFragment must contain a view");
        }

        if (!(mNormalView.getParent() instanceof ViewGroup)) {
            throw new IllegalStateException("mNormalView's parentView must be a ViewGroup");
        }

        ViewGroup parent = (ViewGroup) mNormalView.getParent();
        View.inflate(mActivity, R.layout.layout_loading_view, parent);

        //loading view
        mLoadingView = parent.findViewById(R.id.mLoadingView);
        mLoadingViewText = mLoadingView.findViewById(R.id.mLoadingViewText);
        mLoadingViewText.setTypeface(Utils.getTypeFace(mActivity, "STXingkai.ttf"));

        mTitanic = new Titanic(1000);

        mNormalView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        if (mViewState == Constant.LOADING_VIEW_STATE) return;
        hideCurrentShowViewByState();
        mLoadingView.setVisibility(View.VISIBLE);
        mViewState = Constant.LOADING_VIEW_STATE;
        mTitanic.start(mLoadingViewText);
        Log.d(TAG, "showLoading: ");

    }

    @Override
    public void hideLoading() {


    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showNormalView() {
        if (mViewState == Constant.NORMAL_VIEW_STATE) return;
        hideCurrentShowViewByState();
        mNormalView.setVisibility(View.VISIBLE);
        mViewState = Constant.NORMAL_VIEW_STATE;
        Log.d(TAG, "showNormalView: ");

    }

    @Override
    public void onDestroyView() {
        if (mTitanic != null) {
            mTitanic.cancel();
        }
        super.onDestroyView();
    }

    /**
     * 通过状态去隐藏当前显示的View
     */
    private void hideCurrentShowViewByState() {

        switch (mViewState) {
            case Constant.NORMAL_VIEW_STATE:
                if (mNormalView == null) return;
                mNormalView.setVisibility(View.GONE);
                break;
            case Constant.LOADING_VIEW_STATE:
                if (mLoadingView == null) return;
                mLoadingView.setVisibility(View.GONE);
                break;
            default:
                break;
        }

    }
}
