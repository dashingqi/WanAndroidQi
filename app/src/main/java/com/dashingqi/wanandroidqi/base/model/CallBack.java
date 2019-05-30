package com.dashingqi.wanandroidqi.base.model;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.model
 * @ClassName: CallBack
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 00:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 00:34
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface CallBack<T> {

    void onSuccess(T data);

    void onFailed(T data);

    void onError();

    void onComplete();
}
