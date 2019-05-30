package com.dashingqi.wanandroidqi.base.model;


/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.model
 * @ClassName: BaseModel
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 00:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 00:34
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseModel<T> {

    public T param;

    public BaseModel params(T param) {
        this.param = param;
        return this;
    }

    public abstract void execute(CallBack<T> callback);

}
