package com.baizhi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shiro")
public class ShiroController {

    @RequestMapping("login")
    public String login(String name,String password){
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(name,password);
            subject.login(token);
            return "redirect:/main/main.jsp";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错");
            return "redirect:/error";
        }catch (UnknownAccountException e) {
            System.out.println("账号错");
            return "redirect:/error.jsp";
        }
    }

    @RequestMapping("logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }
}
