package com.example.mopo.Controller;

import com.example.mopo.Common.Result;
import com.example.mopo.Entity.FollowEntity;
import com.example.mopo.Service.Impl.FollowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController {

    @Autowired
    FollowServiceImpl followService;

    @PostMapping("/follow")
    public Result followUser(@RequestBody FollowEntity followEntity){
        return followService.follow(followEntity);
    }

    @PostMapping("/unfollow")
    public Result unfollowUser(@RequestBody FollowEntity followEntity){
        return followService.unfollow(followEntity);
    }

    @PostMapping("/isFollow")
    public Result isFollowUser(@RequestBody FollowEntity followEntity){
        return followService.isFollow(followEntity);
    }

    @PostMapping("/getFans")
    public Result getFans(@RequestBody FollowEntity followEntity){
        return followService.getFans(followEntity);
    }

    @PostMapping("/getFollows")
    public Result getFollows(@RequestBody FollowEntity followEntity){
        return followService.getFollows(followEntity);
    }


}
