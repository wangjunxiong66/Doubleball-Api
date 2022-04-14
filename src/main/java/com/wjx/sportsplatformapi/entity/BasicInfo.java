package com.wjx.sportsplatformapi.entity;

import java.io.Serializable;

/**
 * @author wjx
 * @version 1.0
 * @date 2022/4/12 下午4:05
 */
public class BasicInfo implements Serializable {

    int id ;
    String name ;

    public BasicInfo() {
    }

    public BasicInfo(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "BasicInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
