package com.mopo.controller;

import com.mopo.mapper.UserMapper;
import com.mopo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper UserMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> userList = UserMapper.queryUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }

}
