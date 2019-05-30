package com.dashingqi.wanandroidqi.base.model;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.base.model
 * @ClassName: DataModel
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 00:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 00:33
 * @UpdateRemark:
 * @Version: 1.0
 */
public class DataModel {

    public static BaseModel getInstance(Class clazz) {
        BaseModel mBaseModel = null;
        try {
            mBaseModel = (BaseModel) clazz.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return mBaseModel;
    }
}
