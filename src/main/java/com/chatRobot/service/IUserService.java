package com.chatRobot.service;

import com.chatRobot.domain.UserInfo;

/**
 * Created by XuPengFei on 2017/8/1.
 */
public interface IUserService {
    public UserInfo getUser(String  userName);
}
