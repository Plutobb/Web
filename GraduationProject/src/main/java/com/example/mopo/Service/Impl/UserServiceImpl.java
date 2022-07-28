package com.example.mopo.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mopo.Common.Result;
import com.example.mopo.Entity.DTO.LoginUserDTO;
import com.example.mopo.Entity.UserEntity;
import com.example.mopo.Mapper.UserMapper;
import com.example.mopo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Value("${headImage.url}")
    private String headImageUrl;
    @Value("${headImage.upload.path}")
    private String headImageUploadPath;
    @Autowired
    private UserMapper userMapper;

    public UserEntity selectUser(QueryWrapper<UserEntity> queryWrapper){
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public UserEntity userLogin(LoginUserDTO loginUserDTO) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userNum",loginUserDTO.getUsername());
        userMapper.selectOne(queryWrapper);
        return userMapper.selectOne(queryWrapper);
    }

    public UserEntity getUserInfoByOneColumn(String column,String value){
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userNum",value);
        return userMapper.selectOne(queryWrapper);
    }

    public Result getUserInfoById(long userId){
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userID",userId);
        UserEntity userEntity = userMapper.selectOne(queryWrapper);
        Result result = new Result();
        if (userEntity!=null){
            result.setCode(200);
            result.setData(userEntity);
        }else {
            result.setCode(501);
            result.setMsg("获取用户信息失败！");
        }
        return result;
    }

    public Result updateUserInfo(UserEntity user){
        Result result = new Result();
        if (userMapper.updateUserInfo(user)){
            result.setCode(200);
            result.setMsg("修改用户信息成功！");
        }else {
            result.setCode(505);
            result.setMsg("修改用户信息失败！");
        }
        return result;
    }


    public Result uploadHeadImage(MultipartFile file) throws IOException {
        File uploadParentFile = new File(headImageUploadPath);
        if (!uploadParentFile.exists()){
            uploadParentFile.mkdirs();
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        File uploadFile = new File(headImageUploadPath + uuid + ".jpg");
        file.transferTo(uploadFile);
        Result result = new Result();
        result.setData(headImageUrl+uuid+".jpg");
        result.setCode(200);
        return result;
    }
}
