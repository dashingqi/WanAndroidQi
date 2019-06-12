package com.dashingqi.wanandroidqi.utils;

import com.dashingqi.wanandroidqi.network.entity.BaseResponse;
import com.dashingqi.wanandroidqi.network.http.exception.ApiException;


import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.utils
 * @ClassName: RxUtil
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 15:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 15:52
 * @UpdateRemark: RxJava的封装
 * @Version: 1.0
 */
public class RxUtil {
    private RxUtil() {
        throw new AssertionError();
    }

    /**
     * 切换线程避免每次请求的时候，子线程与主线线程的切换都要写一遍。
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        //网络请求在子线程中
        return observable -> observable.subscribeOn(Schedulers.io())
                //UI的更新切换到主线程中
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 对结果进行处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> handleResult() {
        return upstream ->
                //flatMap是将数据集转化成Observable数据集
                upstream.flatMap((Function<BaseResponse<T>, Observable<T>>) baseResponse ->
                {
                    //当请求成功的时候 == 0 表示请求成功
                    if (baseResponse.getCode() == 0) {
                        //返回数据
                        return createObservable(baseResponse.getData());
                    }
                    //返回异常
                    return Observable.error(new ApiException(baseResponse.getCode(), baseResponse.getMsg()));
                });
    }

    /**
     * 创建请求成功时的数据源
     *
     * @param data
     * @param <T>
     * @return
     */
    private static <T> Observable<T> createObservable(T data) {
        //创建一个Observable
        return Observable.create(emitter -> {
            try {
                //此时调用了观察者的onNext
                emitter.onNext(data);
                emitter.onComplete();

            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }
}
