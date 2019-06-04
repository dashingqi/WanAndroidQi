package com.dashingqi.wanandroidqi.network.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.network.entity
 * @ClassName: BaseResponse
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 16:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 16:05
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BaseResponse<T> {

    @SerializedName("errorCode")
    private int code;
    @SerializedName("errorMsg")
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
