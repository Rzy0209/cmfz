package com.baizhi.controller;

import com.baizhi.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("code")
public class CodeController {


    @RequestMapping("creatCode")
    public String creatCode(HttpServletResponse response, HttpSession session) throws Exception {
        CreateValidateCode cc = new CreateValidateCode();
        String code = cc.getCode();
        session.setAttribute("code", code);
        cc.write(response.getOutputStream());
        return null;
    }

}
