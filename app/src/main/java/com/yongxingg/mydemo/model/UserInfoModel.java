package com.yongxingg.mydemo.model;

import java.io.Serializable;

/**
 * Created by gaoyongxing on 2018-11-20.
 */
public class UserInfoModel implements Serializable {
    private String name;
    private String password;

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
}
