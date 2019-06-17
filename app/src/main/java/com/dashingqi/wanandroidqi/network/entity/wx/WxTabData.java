package com.dashingqi.wanandroidqi.network.entity.wx;

import java.util.List;

public class WxTabData {
    /**
     * children": [ ],
     * "courseId": 13,
     * "id": 408,
     * "name": "鸿洋",
     * "order": 190000,
     * "parentChapterId": 407,
     * "userControlSetTop": false,
     * "visible": 1
     */
    private String courseId;
    private String id;
    private String name;
    private String order;
    private String parentChapterId;
    private String userControlSetTop;
    private String visible;
    private List<?> children;

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getParentChapterId() {
        return parentChapterId;
    }

    public void setParentChapterId(String parentChapterId) {
        this.parentChapterId = parentChapterId;
    }

    public String getUserControlSetTop() {
        return userControlSetTop;
    }

    public void setUserControlSetTop(String userControlSetTop) {
        this.userControlSetTop = userControlSetTop;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }
}
