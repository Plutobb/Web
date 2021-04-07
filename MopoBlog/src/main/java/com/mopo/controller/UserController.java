package com.mopo.controller;

import com.mopo.mapper.UserMapper;
import com.mopo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserMapper UserMapper;

    @GetMapping("/user")
    public String queryUserList(Model model){
        List<User> userList = UserMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        model.addAttribute("users",userList);
        return "user";
    }

}
