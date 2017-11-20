package com.chatRobot.service;

import com.chatRobot.domain.AreaInfo;

import java.util.List;

/**
 * Created by XuPengFei on 2017/8/2.
 */
public interface AreaService {
    public List<AreaInfo> getAllArea(Integer pId);
}
