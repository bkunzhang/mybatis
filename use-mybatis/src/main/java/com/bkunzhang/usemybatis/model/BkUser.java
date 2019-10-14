package com.bkunzhang.usemybatis.model;

import java.io.Serializable;

public class BkUser implements Serializable {
    private Integer id;

    private String username;

    private Integer age;

    private String xxYy;

    private static final long serialVersionUID = 1L;

    public BkUser() {}

    public BkUser(String username, Integer age, String xxYy) {
        this.username = username;
        this.age = age;
        this.xxYy = xxYy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getXxYy() {
        return xxYy;
    }

    public void setXxYy(String xxYy) {
        this.xxYy = xxYy == null ? null : xxYy.trim();
    }
}