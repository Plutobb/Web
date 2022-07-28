package com.example.mopo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mopo.Entity.CommentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity> {
    @Select("select id, user_Id, time, content, pid, origin_Id, video_Id, userName,headImage from user_comment com left join user_info user on com.user_Id = user.userID where com.video_Id = #{videoId} order by id desc")
    List<CommentEntity> getUserComments(@Param("videoId") Long videoId);
}
