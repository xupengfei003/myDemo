package com.chatRobot.controller;

import com.chatRobot.domain.AreaInfo;
import com.chatRobot.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://localhost:8080/area/getAll?pId=0
 * Created by XuPengFei on 2017/8/2.
 */
@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getAll" , method = RequestMethod.GET)
    public ModelAndView getAllArea(){
        List<AreaInfo> pro = null;
        List<AreaInfo> city =null;
        List<AreaInfo> county =null;
        Map<String ,List<AreaInfo>> map = new HashMap<String ,List<AreaInfo>>();
        pro = areaService.getAllArea(1);
        city = areaService.getAllArea(2);
        county = areaService.getAllArea(3);
        map.put("pro",pro);
        map.put("city",city);
        map.put("county",county);

        return new ModelAndView("areaList","map",map);
    }


}
