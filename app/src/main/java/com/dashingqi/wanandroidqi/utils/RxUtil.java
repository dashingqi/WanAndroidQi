package com.dashingqi.wanandroidqi.utils;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.utils
 * @ClassName: RxUtil
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 15:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 15:52
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RxUtil {
    private RxUtil() {
        throw new AssertionError();
    }

    /**
     * 切换线程
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
