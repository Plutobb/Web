package mopo.controller;

import mopo.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("test")//Autowired 搭配 Qualifier 指定bean名称
    private Map<String,String> test;

    @Resource(name = "user1")//Resource 可以直接name来指定bean
    private User user1;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(){
        return test;
    }

    @RequestMapping("/m")
    public String l1(){
        return ("forward:/user/login");
    }
    @RequestMapping("/test/{key}")
    @ResponseBody
    public Object test(@PathVariable("key") String key){
        System.out.println("========="+ test.get(key));
        return test;
    }
}
