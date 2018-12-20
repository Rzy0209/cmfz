package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/menu")
@Log4j
public class MenuController {
    @Resource
    MenuService menuService;

    @RequestMapping("showAll")
    @ResponseBody
    public List<Menu> showAll() {
        List<Menu> list = menuService.queryAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("two")
    public List<Menu> two(Integer id) {
        List<Menu> list = menuService.queryAll(id);
        return list;
    }
}
