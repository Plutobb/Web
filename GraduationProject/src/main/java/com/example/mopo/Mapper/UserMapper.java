package com.example.mopo.Mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mopo.Entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    @Update("update user_info set userName = #{userName},userNum=#{userNum},userAge=#{userAge},userIntroduce=#{userIntroduce},password=#{password},headImage=#{headImage} where userID = #{userId};")
    Boolean updateUserInfo(UserEntity user);
}
