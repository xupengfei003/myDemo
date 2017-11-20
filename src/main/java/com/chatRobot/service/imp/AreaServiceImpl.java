package com.chatRobot.service.imp;

import com.chatRobot.dao.AreaDao;
import com.chatRobot.domain.AreaInfo;
import com.chatRobot.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XuPengFei on 2017/8/2.
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;
    @Override
    public List<AreaInfo> getAllArea(Integer pId) {
        return areaDao.findAllArea(pId);
    }
}
