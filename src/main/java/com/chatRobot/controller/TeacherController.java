package com.chatRobot.controller;

import com.chatRobot.domain.PageInfo;
import com.chatRobot.domain.TeacherInfo;
import com.chatRobot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by XuPengFei on 2017/8/2.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacherList")
    public ModelAndView getAllComm(){
        List<TeacherInfo> teacherList = teacherService.getAllTeachers();
        if(null == teacherList){
            String msg = "抱歉，你的私人老师吃饭去了，现在不在哦！";
            return  new ModelAndView("teacherList","msg",msg);
        }
        return  new ModelAndView("teacherList","teacherList",teacherList);
    }

    @RequestMapping("/addTeacher")
    public ModelAndView addTeacher(){
        return  new ModelAndView("addTeacher");
    }

    @RequestMapping("/addMyTeacher")
    public ModelAndView addMyTeacher(HttpServletRequest request){
        String tName = request.getParameter("tName");
        String tLesson = request.getParameter("tLesson");
        String tNo = request.getParameter("tNo");
        TeacherInfo tt = new TeacherInfo();
        tt.settName(tName);
        tt.settLesson(tLesson);
        tt.settNo(tNo);
        boolean flag = teacherService.addTeacher(tt);

        if(flag){
            List<TeacherInfo> teacherList = teacherService.getAllTeachers();
            return  new ModelAndView("teacherList","teacherList",teacherList);
        }else {
            String msg = "抱歉，添加失败，请重新添加！";
            return  new ModelAndView("addTeacher","msg",msg);
        }
    }

    @RequestMapping("/deleteTeacher")
    public ModelAndView deleteTeacher(Integer tId){
        if(null != tId){
            boolean flag = teacherService.deleteTeacher(tId);

            if (flag){
                List<TeacherInfo> teacherList = teacherService.getAllTeachers();
                return  new ModelAndView("teacherList","teacherList",teacherList);
            }else {
                String msg = "操作失败，请重新操作！";
                return  new ModelAndView("error","msg",msg);
            }
        }
        String msg = "操作失败，请重新操作！";
        return  new ModelAndView("error","msg",msg);
    }


    @RequestMapping("/updateTeacher")
    public  ModelAndView updateTeacher(Integer tId){
        if(null != tId){
            TeacherInfo teacher  = teacherService.getTeacherById(tId);
            if (null != teacher){
                return  new ModelAndView("updateT","teacher",teacher);
            }else {
                String msg = "操作失败，请重新操作！";
                return  new ModelAndView("error","msg",msg);
            }
        }
        String msg = "操作失败，请重新操作！";
        return  new ModelAndView("error","msg",msg);
    }

    @RequestMapping("/submitAddTeacher")
    public ModelAndView submitAddTeacher(HttpServletRequest request){
        String tId = request.getParameter("tId");
        String tName = request.getParameter("tName");
        String tLesson = request.getParameter("tLesson");
        String tNo = request.getParameter("tNo");
        System.out.println("----------ttId-tName-tLesson-tNo--------->>>>: " + tId + tName + tLesson + tNo);
        TeacherInfo tt = new TeacherInfo();
        tt.settId(Integer.valueOf(tId));
        tt.settName(tName);
        tt.settLesson(tLesson);
        tt.settNo(tNo);
        System.out.println("----------tt.toString()------------>>>>: " +tt.toString());
        System.out.println("-----------flag----------->>>>: " +teacherService.updateTeacher(tt));
        boolean flag = teacherService.updateTeacher(tt);
        if (flag){
            List<TeacherInfo> teacherList = teacherService.getAllTeachers();
            return  new ModelAndView("teacherList","teacherList",teacherList);
        }else {
            String msg = "操作失败，请重新操作！";
            return  new ModelAndView("error","msg",msg);
        }
    }

    @RequestMapping(value = "/pageT")
    public ModelAndView getPageT(PageInfo pageInfo){
        List<TeacherInfo> teacherList = teacherService.getPageAllT(pageInfo);
        return new ModelAndView("pageAllT","pageT",teacherList);
    }
}
