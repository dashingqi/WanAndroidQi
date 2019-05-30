package com.dashingqi.wanandroidqi.model.home;

import android.os.Handler;

import com.dashingqi.wanandroidqi.base.model.BaseModel;
import com.dashingqi.wanandroidqi.base.model.CallBack;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.model.home
 * @ClassName: HomeModel
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 00:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 00:37
 * @UpdateRemark:
 * @Version: 1.0
 */
public class HomeModel extends BaseModel<String> {
    @Override
    public void execute(CallBack<String> callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess("HomeFragment");
                callback.onComplete();
            }
        }, 3000);
    }
}


