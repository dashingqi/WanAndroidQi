package com.dashingqi.wanandroidqi.network.entity.system;

import java.util.List;

/**
 * "courseId": 13,
 * "id": 150,
 * "name": "开发环境",
 * "order": 1,
 * "parentChapterId": 0,
 * "userControlSetTop": false,
 * "visible": 1
 */
public class SystemDataBean {
    private int coursedId;
    private int id;
    private String name;
    private int order;
    private int parentChapterId;
    private boolean userControlSetTop;
    private int visible;
    private List<SystemChildrenDataBean> children;

    public int getCoursedId() {
        return coursedId;
    }

    public void setCoursedId(int coursedId) {
        this.coursedId = coursedId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(int parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public boolean isUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(boolean userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public List<SystemChildrenDataBean> getChildren() {
        return children;
    }

    public void setChildren(List<SystemChildrenDataBean> children) {
        this.children = children;
    }
}
