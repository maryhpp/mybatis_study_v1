package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //代表这个类会被spring接管，被这个注解的类，如果返回值是spring，并且有具体页面可以跳转，那么就会被视图解析器解析
public class ControllerTest2 {

    @RequestMapping("/t1")
    public String test1(Model model){

        model.addAttribute("msg","ControllerTest2");


        return "test"; //WEB-INF/test.jsp
    }

}
