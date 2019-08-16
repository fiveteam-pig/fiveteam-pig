package com.ytd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/UserMainTest")
public class UserTest {

    @RequestMapping("/Test")
    public String test(HttpServletRequest request){
        request.getParameter("version");
        request.getParameter("txCode");
        System.out.println("111111");
        return "openCount";
    }
}
