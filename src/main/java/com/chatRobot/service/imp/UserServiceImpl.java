package com.chatRobot.service.imp;

import com.chatRobot.dao.IUserDao;
import com.chatRobot.domain.UserInfo;
import com.chatRobot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XuPengFei on 2017/8/1.
 */
@Service
public class UserServiceImpl implements IUserService {
   @Autowired
    private IUserDao UserDao;
    @Override
    public UserInfo getUser(String userName) {
        return this.UserDao.findUser(userName);
    }
}
