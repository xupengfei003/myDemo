package com.chatRobot.dao;

import com.chatRobot.domain.PageInfo;
import com.chatRobot.domain.TeacherInfo;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by XuPengFei on 2017/8/2.
 */
public interface TeacherDao {
    List<TeacherInfo> findAllTeachers();
    public boolean insertTeacher(@Param("tt") TeacherInfo  tt);
    public boolean deleteTeacher(Integer tId);
    public boolean updateTeacher(@Param("tt") TeacherInfo tt);
    public TeacherInfo findTeacherById(Integer tId);
    public List<TeacherInfo> findPageAllT(PageInfo pageInfo);
    public  int countT();
}
