package com.wjx.sportsplatformapi.entity;

import java.io.Serializable;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/10/27 下午3:42
 */
//  分支导航
public class SubMenu implements Serializable {

    private int id;
    private String title;
    private String path;

    public SubMenu() {
    }

    public SubMenu(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "SubMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
