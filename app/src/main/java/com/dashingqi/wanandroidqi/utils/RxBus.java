package com.dashingqi.wanandroidqi.utils;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.utils
 * @ClassName: RxBus
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 19:39
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 19:39
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RxBus {
    private final Subject<Object> mSubject;
    private static volatile RxBus mRxBus;

    public RxBus() {
        //因为Subject是非线程安全的，所以转成了一个SerializedSubject
        this.mSubject = PublishSubject.create().toSerialized();
    }

    /**
     * 使用了单利双重检查模式
     *
     */
    public static RxBus getInstance() {
        if (mRxBus == null) {
            synchronized (RxBus.class) {
                if (mRxBus == null) {
                    mRxBus = new RxBus();
                }
            }
        }
        return mRxBus;
    }

    /**
     * 发送事件
     *
     * @param o
     */
    public void post(Object o) {
        mSubject.onNext(o);
    }

    /**
     * 根据传递的eventType类型返回特定类型的观察者
     *
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return mSubject.ofType(eventType);
    }
}
