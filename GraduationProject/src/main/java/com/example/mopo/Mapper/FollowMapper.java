package com.example.mopo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mopo.Entity.FollowEntity;
import com.example.mopo.Entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FollowMapper extends BaseMapper<FollowEntity> {
    @Insert("insert into user_follow (user_id, follow_user_id, follow_time) VALUE (#{userId}, #{followUserId},#{followTime});")
    Boolean follow(FollowEntity followEntity);

    @Delete("delete from user_follow where user_id = #{userId} and follow_user_id = #{followUserId};")
    Boolean unFollow(FollowEntity followEntity);

    @Select("select * from user_follow where user_id = #{userId} and follow_user_id = #{followUserId};")
    FollowEntity isFollow(FollowEntity followEntity);

    @Select("select userID, userName, userIntroduce, userAge, fansCount, followCount, userNum, headImage from user_info user left join user_follow follow on follow.user_id = user.userID where follow.follow_user_id = #{userId}")
    List<UserEntity> getFans(FollowEntity followEntity);

    @Select("select userID, userName, userIntroduce, userAge, fansCount, followCount, userNum, headImage from user_info user left join user_follow follow on follow.follow_user_id = user.userID where follow.user_id = #{userId}")
    List<UserEntity> getFollows(FollowEntity followEntity);
}
