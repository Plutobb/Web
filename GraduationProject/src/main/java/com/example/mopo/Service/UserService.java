package com.example.mopo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mopo.Entity.DTO.LoginUserDTO;
import com.example.mopo.Entity.UserEntity;

public interface UserService extends IService<UserEntity> {
    UserEntity userLogin(LoginUserDTO loginUserDTO);
}
