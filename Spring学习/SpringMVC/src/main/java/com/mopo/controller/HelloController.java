package com.mopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String helloController(Model model){
        model.addAttribute("msg","helloSpringMVC");
        return "hello";

    }
}
