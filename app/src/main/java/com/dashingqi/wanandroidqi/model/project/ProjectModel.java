package com.dashingqi.wanandroidqi.model.project;

import android.os.Handler;

import com.dashingqi.wanandroidqi.base.model.BaseModel;
import com.dashingqi.wanandroidqi.base.model.CallBack;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.model.project
 * @ClassName: ProjectModel
 * @Author: DashingQI
 * @CreateDate: 2019-05-31 17:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-05-31 17:32
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ProjectModel extends BaseModel<String> {
    @Override
    public void execute(CallBack<String> callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess("ProjectFragment");
                callback.onComplete();
            }
        }, 3000);
    }
}
