package mopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    @ResponseBody
    public Object login(){
        Map<String,String> map = new HashMap<>();
        map.put("疾风剑豪","亚索");
        map.put("封魔剑魂","永恩");
        return map;
    }
}
