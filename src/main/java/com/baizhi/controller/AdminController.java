package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;

    @RequestMapping("login")
    public String login(String name, String password,String code, HttpSession session) {
        Admin admin = adminService.getOne(name, password);
        String  cd = (String) session.getAttribute("code");
        if (admin != null && cd.equals(code)) {
            session.setAttribute("name", admin.getName());
            return "redirect:/main/main.jsp";
        } else {
            return "redirect:/login.jsp";
        }
    }
}
