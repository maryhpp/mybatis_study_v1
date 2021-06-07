package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/user")
public class UserController {

    //localhost:8080/user/t1?name=xxx;
    //@GetMapping("/t1")
    @RequestMapping("/user/t1")
    public String test1(String name, Model model){
        //1.接受前端参数
        System.out.println("接受到前端的参数为：" +name);
        //2.将返回的结果传递到前端，Model
        model.addAttribute("msg", name);
        //3.跳转视图
        return "test";
    }
}
