package com.chatRobot.service;

import com.chatRobot.domain.PageInfo;
import com.chatRobot.domain.TeacherInfo;

import java.util.List;

/**
 * Created by XuPengFei on 2017/8/2.
 */
public interface TeacherService {
    public List<TeacherInfo> getAllTeachers();
    public boolean addTeacher(TeacherInfo  tt);
    public boolean deleteTeacher(Integer tId);
    public boolean updateTeacher(TeacherInfo tt);
    public TeacherInfo getTeacherById(Integer tId);
    public List<TeacherInfo> getPageAllT(PageInfo pageInfo);
}
