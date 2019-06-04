package com.dashingqi.wanandroidqi.base.Observer;

import android.util.Log;

import com.dashingqi.wanandroidqi.R;
import com.dashingqi.wanandroidqi.application.ApplicationQi;
import com.dashingqi.wanandroidqi.base.view.BaseView;
import com.dashingqi.wanandroidqi.network.http.exception.ApiException;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.Observer
 * @ClassName: BaseObserver
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 20:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 20:31
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BaseObserver<T> extends ResourceObserver<T> {
    private static final String TAG = "BaseObserver";

    private BaseView mView;
    private boolean isShowErrorView = true;
    private boolean isShowLoading = true;

    private BaseObserver() {

    }

    protected BaseObserver(BaseView view) {
        this(view, true, true);

    }

    protected BaseObserver(BaseView view, boolean isShowErrorView) {
        this(view, isShowErrorView, true);
    }

    protected BaseObserver(BaseView view, boolean isShowErrorView, boolean isShowLoading) {
        mView = view;
        this.isShowErrorView = isShowErrorView;
        this.isShowLoading = isShowLoading;
    }

    @Override
    protected void onStart() {
        if (isShowLoading) mView.showLoading();
    }

    @Override
    public void onNext(T t) {
        mView.showNormalView();
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof UnknownHostException) {
            Log.e(TAG, "netWorkError: " + e.getMessage());
            networkError();
        } else if (e instanceof InterruptedException) {
            Log.e(TAG, "timeout: " + e.getMessage());
            timeoutError();
        } else if (e instanceof HttpException) {
            Log.e(TAG, "http错误:" + e.getMessage());
            httpError();
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            Log.e(TAG, "解析错误" + e.getMessage());
            parseError();
        } else if (e instanceof ApiException) {
            Log.e(TAG, "unKnow: " + ((ApiException) e).getmErrorCode());
            ApiException apiException = (ApiException) e;
            //Cookie过期处理
            if (apiException.getmErrorCode() == -1001) {
                //重新发起登陆
            } else {
                Log.d(TAG, "unKnow: " + e.toString());
                unknown();
            }
        }

    }

    @Override
    public void onComplete() {

    }

    /**
     * 未知错误
     */
    protected void unknown() {
        mView.showToast(ApplicationQi.getContext().getString(R.string.app_name));
        if (isShowErrorView) mView.showErrorView();
    }

    /**
     * 解析错误
     */
    protected void parseError() {
        mView.showToast(ApplicationQi.getContext().getString(R.string.error_parse));
        if (isShowErrorView) mView.showErrorView();
    }

    /**
     * http错误
     */
    protected void httpError() {
        mView.showToast(ApplicationQi.getContext().getString(R.string.error_http));
        if (isShowErrorView) {
            Log.e(TAG, "httpError: ");
            mView.showErrorView();
        }
    }

    /**
     * 网络超时异常
     */
    protected void timeoutError() {
        mView.showToast(ApplicationQi.getContext().getString(R.string.error_timeout));
        if (isShowErrorView) mView.showErrorView();
    }

    /**
     * 网络不可用异常
     */
    protected void networkError() {
        mView.showToast(ApplicationQi.getContext().getString(R.string.error_network));
        if (isShowErrorView) mView.showErrorView();
    }
}
