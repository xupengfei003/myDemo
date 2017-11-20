package com.chatRobot.controller;

import com.chatRobot.domain.UserInfo;
import com.chatRobot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by XuPengFei on 2017/8/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/login")
    public ModelAndView selectUser(HttpServletRequest request,
                                   HttpServletResponse response)throws IOException{
              request.setCharacterEncoding("UTF-8");
              response.setCharacterEncoding("UTF-8");
              String userName=request.getParameter("userName");
              UserInfo user=userService.getUser(userName);
              if(null == user){
                  String message = "你输入的用户名有误或者不存在，请重新输入！";
                  return new ModelAndView("success","message",message);
              }
              System.out.print("----------------"+user.getUserName()+ user.getUserPass()+user.getUserSex());

       return new ModelAndView("success","user",user);
    }
}
