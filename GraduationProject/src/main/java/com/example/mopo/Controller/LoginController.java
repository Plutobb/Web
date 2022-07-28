package com.example.mopo.Controller;

import com.example.mopo.Common.Result;
import com.example.mopo.Entity.DTO.LoginUserDTO;
import com.example.mopo.Entity.UserEntity;
import com.example.mopo.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/login")
    public Result login(@RequestBody LoginUserDTO user){
        UserEntity userEntity = userServiceImpl.userLogin(user);
        Result result = new Result();
        if (userEntity != null){
            if (!user.getPassword().equals(userEntity.getPassword())){
                result.setMsg("密码错误");
            }else {
                result.setMsg("登录成功");
                result.setData(userEntity);
            }
        }else {
            result.setMsg("用户不存在");
        }
        result.setCode(200);
        return result;
    }
}

