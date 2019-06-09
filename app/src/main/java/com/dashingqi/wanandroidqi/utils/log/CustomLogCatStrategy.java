package com.dashingqi.wanandroidqi.utils.log;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.orhanobut.logger.LogStrategy;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.utils.log
 * @ClassName: CustomLogCatStrategy
 * @Author: DashingQI
 * @CreateDate: 2019-06-09 14:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-09 14:44
 * @UpdateRemark: 解决Android3.1 Logger日志打印排版的问题
 * @Version: 1.0
 */
public class CustomLogCatStrategy implements LogStrategy {
    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        Log.println(priority, randomKey() + tag, message);
    }

    private int last;

    private String randomKey() {
        int random = (int) (10 * Math.random());
        if (random == last) {
            random = (random + 1) % 10;
        }
        last = random;
        return String.valueOf(random);
    }
}
