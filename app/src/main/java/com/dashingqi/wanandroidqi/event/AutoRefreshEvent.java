package com.dashingqi.wanandroidqi.event;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.event
 * @ClassName: AutoRefreshEvent
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 19:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 19:47
 * @UpdateRemark:
 * @Version: 1.0
 */
public class AutoRefreshEvent {
    private boolean isAutoRefresh;

    public boolean isAutoRefresh() {
        return isAutoRefresh;
    }

    public void setAutoRefresh(boolean autoRefresh) {
        isAutoRefresh = autoRefresh;
    }
}
