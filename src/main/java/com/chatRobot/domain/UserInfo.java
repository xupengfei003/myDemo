package com.chatRobot.domain;

import java.util.Date;

/**
 * Created by XuPengFei on 2017/8/1.
 */
public class UserInfo {
    private long userId;
    private String userPass;
    private String userName;
    private String userSex;
    private Long userDate;

    public Long getUserDate() {
        return userDate;
    }

    public void setUserDate(Long userDate) {
        this.userDate = userDate;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
