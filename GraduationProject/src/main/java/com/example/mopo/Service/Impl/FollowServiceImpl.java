package com.example.mopo.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mopo.Common.Result;
import com.example.mopo.Entity.FollowEntity;
import com.example.mopo.Entity.UserEntity;
import com.example.mopo.Mapper.FollowMapper;
import com.example.mopo.Service.FollowService;
import com.example.mopo.Utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, FollowEntity> implements FollowService {

    @Autowired
    FollowMapper followMapper;

    public Result follow(FollowEntity followEntity){
        followEntity.setFollowTime(TimeUtil.getNowTime());
        Result result = new Result();
        if (followMapper.follow(followEntity)){
            result.setCode(200);
            result.setMsg("关注成功！");
        }else {
            result.setCode(503);
            result.setMsg("关注失败！");
        }
        return result;
    }

    public Result unfollow(FollowEntity followEntity){
        Result result = new Result();
        if (followMapper.unFollow(followEntity)){
            result.setCode(200);
            result.setMsg("取消关注成功！");
        }else {
            result.setCode(503);
            result.setMsg("取消关注失败！");
        }
        return result;
    }

    public Result isFollow(FollowEntity followEntity){
        Result result = new Result();
        if (followMapper.isFollow(followEntity) != null){
            result.setCode(200);
            result.setMsg("已经关注该用户！");
        }else {
            result.setCode(503);
            result.setMsg("没有关注该用户！");
        }
        return result;
    }

    public Result getFans(FollowEntity followEntity){
        List<UserEntity> fans = followMapper.getFans(followEntity);
        Result result = new Result();
        result.setCode(200);
        result.setData(fans);
        result.setMsg("获取粉丝信息！");
        return result;
    }
    public Result getFollows(FollowEntity followEntity){
        List<UserEntity> follows = followMapper.getFollows(followEntity);
        Result result = new Result();
        result.setCode(200);
        result.setData(follows);
        result.setMsg("获取关注用户信息！");
        return result;
    }

}
