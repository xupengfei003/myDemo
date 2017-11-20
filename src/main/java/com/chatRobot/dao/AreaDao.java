package com.chatRobot.dao;

import com.chatRobot.domain.AreaInfo;

import java.util.List;

/**
 * Created by XuPengFei on 2017/8/2.
 */
public interface AreaDao {
    public List<AreaInfo> findAllArea(Integer pId);
}
