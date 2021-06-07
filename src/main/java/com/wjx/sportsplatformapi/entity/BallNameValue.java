package com.wjx.sportsplatformapi.entity;

/**
 * @author wjx
 * @version 1.0
 * @date 2021/6/4 下午5:15
 */
public class BallNameValue {
    private int value;
    private String name;

    public BallNameValue() {
    }

    public BallNameValue(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BallNameValue{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
