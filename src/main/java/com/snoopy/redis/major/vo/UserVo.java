package com.snoopy.redis.major.vo;

import java.io.Serializable;

/**
 * Created by hnair20160706 on 2016/12/15.
 */
public class UserVo implements Serializable{
    private String id;//用户id
    private String name;//用户名
    private String password;//用户密码

    public UserVo() {
    }

    public UserVo(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
