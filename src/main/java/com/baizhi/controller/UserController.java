package com.baizhi.controller;

import com.baizhi.entity.Province;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping("showActive")
    public Map<String,Integer> showAction(){
        Integer oneWeek = userService.getOneWeek();
        Integer twoWeek = userService.getTwoWeek();
        Integer threeWeek = userService.getThreeWeek();
        Map<String,Integer> map= new HashMap<>();
        map.put("一周",oneWeek);
        map.put("二周",twoWeek);
        map.put("三周",threeWeek);
        return map;
    }
    @ResponseBody
    @RequestMapping("showProvince")
    public List<Province> showProvince(){
        return userService.getProvince();
    }


}
