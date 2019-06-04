package com.dashingqi.wanandroidqi.network.entity.home;

import java.util.List;

/**
 * @ProjectName: WanAndroidQi
 * @Package: com.dashingqi.wanandroidqi.network.entity.home
 * @ClassName: ArticlesBean
 * @Author: DashingQI
 * @CreateDate: 2019-06-04 16:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2019-06-04 16:17
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ArticlesBean {
    private int currentPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<ArticleBean> datas;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ArticleBean> getDatas() {
        return datas;
    }

    public void setDatas(List<ArticleBean> datas) {
        this.datas = datas;
    }
}
