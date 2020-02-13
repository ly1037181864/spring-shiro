package com.topideal.cn.springbootshiro.entity;

/**
 * @program: springboot-shiro
 * @description
 * @author: liuyou
 * @create: 2020-02-13 00:32
 **/
public class User {
    private Integer id;
    private String name;
    private String password;
    private String permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
