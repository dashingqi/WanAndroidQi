package com.dashingqi.wanandroidqi.model.setting;

import android.os.Handler;

import com.dashingqi.wanandroidqi.base.model.BaseModel;
import com.dashingqi.wanandroidqi.base.model.CallBack;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.model.setting
 * @ClassName: SettingModel
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 09:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 09:25
 * @UpdateRemark:
 * @Version: 1.0
 */
public class SettingModel extends BaseModel<String> {
    @Override
    public void execute(CallBack<String> callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess("SettingFragment");
                callback.onComplete();
            }
        }, 3000);
    }
}
