package com.example.sysa.util;

import java.io.Serializable;

/**
 * @Description : TODO
 * @Author : xiaodao
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
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
