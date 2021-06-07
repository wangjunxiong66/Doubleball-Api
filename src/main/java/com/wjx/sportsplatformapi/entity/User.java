package com.wjx.sportsplatformapi.entity;

/**
 * 用户实体
 */
public class User {

    private int id;
    private String username; //  用户名
    private String password; //  密码
    private String email; //  邮箱
    private String role; //  角色
    private boolean state; //  状态。此处不能使用 Boolean，只能使用boolean。boolean是基本数据类型，Boolean是它的封装类，和其他类一样，有属性有方法，可以new。例如:Boolean flag = new Boolean("true");  boolean则不可以用new实例化！ Boolean是boolean的实例化对象类，和Integer对应int一样。自jdk1.5.0以上版本后，Boolean在"赋值"和判断上和boolean一样，即是你: booleanb1 = true 或者Boolean b2 = true 都可以。

    public User() {
    }

    public User(String username, String password, String email, String role, boolean state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean isState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                '}';
    }
}
