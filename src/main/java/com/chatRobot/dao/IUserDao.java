package com.chatRobot.dao;

import com.chatRobot.domain.UserInfo;

/**
 * Created by XuPengFei on 2017/8/1.
 */
public interface IUserDao {
  UserInfo findUser(String  userName);
}
