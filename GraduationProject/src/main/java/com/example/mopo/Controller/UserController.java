package com.example.mopo.Controller;

import com.example.mopo.Common.Result;
import com.example.mopo.Entity.UserEntity;
import com.example.mopo.Service.Impl.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @GetMapping("/getUserInfo")
    public List<UserEntity> getList() {
        return userService.list();
    }

    @ResponseBody
    @PostMapping("/userInfo")
    public Result getUserInfo(@RequestParam("userId") long userId) {
        return userService.getUserInfoById(userId);
    }


    @ResponseBody
    @PostMapping("/userInfo/update")
    public Result updateUserInfo(@RequestBody UserEntity user) throws Exception {
        return userService.updateUserInfo(user);
    }

    @ResponseBody
    @PostMapping("/userInfo/uploadHeadImage")
    public Result updateUserInfo(MultipartFile file) throws Exception {
        return userService.uploadHeadImage(file);
    }

}
