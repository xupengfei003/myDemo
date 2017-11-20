package com.chatRobot.service.imp;

import com.chatRobot.dao.TeacherDao;
import com.chatRobot.domain.PageInfo;
import com.chatRobot.domain.TeacherInfo;
import com.chatRobot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XuPengFei on 2017/8/2.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<TeacherInfo> getAllTeachers() {
        return teacherDao.findAllTeachers();
    }

    @Override
    public boolean addTeacher(TeacherInfo tt) {
        return teacherDao.insertTeacher(tt);
    }

    @Override
    public boolean deleteTeacher(Integer tId) {
        return teacherDao.deleteTeacher(tId);
    }

    @Override
    public boolean updateTeacher(TeacherInfo tt) {
        return teacherDao.updateTeacher(tt);
    }

    @Override
    public TeacherInfo getTeacherById(Integer tId) {
        return teacherDao.findTeacherById(tId);
    }

    @Override
    public List<TeacherInfo> getPageAllT(PageInfo pageInfo)
    {
        if (pageInfo == null) {
            pageInfo = new PageInfo();
        }
        Integer rows = teacherDao.countT();//查询数据库总的数据行数
        pageInfo.setPageNo(3);
        pageInfo.setPageSize(4);
        pageInfo.setTotalCount(rows); // 设置总的数据行数是数据库查询到的
        return teacherDao.findPageAllT(pageInfo);
    }
}