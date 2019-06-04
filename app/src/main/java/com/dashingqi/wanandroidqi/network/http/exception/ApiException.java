package com.dashingqi.wanandroidqi.network.http.exception;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.network.http.exception
 * @ClassName: ApiException
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 19:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 19:26
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ApiException extends Exception {

    private final int mErrorCode;
    private final String mErrorMessage;


    public ApiException(int mErrorCode, String mErrorMessage) {
        this.mErrorCode = mErrorCode;
        this.mErrorMessage = mErrorMessage;
    }

    public int getmErrorCode() {
        return mErrorCode;
    }

    public String getmErrorMessage() {
        return mErrorMessage;
    }
}
