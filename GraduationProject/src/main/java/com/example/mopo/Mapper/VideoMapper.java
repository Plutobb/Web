package com.example.mopo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mopo.Entity.UserUpEntity;
import com.example.mopo.Entity.VideoEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VideoMapper extends BaseMapper<VideoEntity> {

    @Update("update video_info set video_info.video_is_delete = 1 where video_id = #{videoId}")
    Boolean deleteVideo(@Param("videoId") long videoId);

    @Select("select video_id, user_id, video_upload_time, video_introduce, video_url,video_image, video_up_num,video_play_num,video_title, video_star, video_type, video_tag,video_state, userName,headImage from video_info video join user_info user on video.user_id = user.userID where video.video_is_delete = 0 and video.video_state = 1")
    List<VideoEntity> getAllVideos();

    @Select("select video_id, user_id, video_upload_time, video_introduce, video_score, video_url,video_image, video_up_num,video_play_num,video_title, video_star, video_type, video_state, userName,headImage from video_info video join user_info user on video.user_id = user.userID where video.video_is_delete = 0 and video.video_state = 1 order by video.video_score desc ")
    List<VideoEntity> getHotVideos();

    @Select("select video_id, user_id, video_upload_time, video_introduce, video_url,video_image, video_up_num,video_play_num,video_title, video_star, video_type, video_state, userName,headImage from video_info video join user_info user on video.user_id = user.userID where (video_title like concat('%',#{searchInput},'%') or video_introduce like concat('%',#{searchInput},'%')) and video.video_is_delete = 0 and video.video_state = 1")
    List<VideoEntity> getVideosBySearch(@Param("searchInput") String searchInput);

    @Select("select video_id, user_id, video_upload_time, video_introduce, video_url,video_image, video_up_num,video_play_num,video_title, video_star, video_type, video_state, userName,headImage from video_info video join user_info user on video.user_id = user.userID where video.video_type = #{type} and video.video_is_delete = 0 and video.video_state = 1")
    List<VideoEntity> getVideosByType(@Param("type") String type);

    @Update("update video_info set video_up_num = video_up_num+1 where video_id = #{videoId}")
    Boolean upVideo(@Param("videoId") long videoId);

    @Update("update video_info set video_up_num = video_up_num-1 where video_id = #{videoId}")
    Boolean downVideo(@Param("videoId") long videoId);

    @Select("select * from user_up where video_id = #{videoId} and user_id = #{userId}")
    List<UserUpEntity> isUp(@Param("userId") long userId,@Param("videoId") long videoId);

    @Insert("insert into user_up (user_id, video_id, up_time) VALUE (#{userId},#{videoId},#{upTime});")
    Boolean insertUserUp(UserUpEntity userUp);

    @Delete("delete from user_up where user_id = #{userId} and video_id = #{videoId}")
    Boolean delUserUp(UserUpEntity userUp);

    @Update("update video_info set video_play_num = video_play_num + 1 where video_id = #{videoId}")
    Boolean playNumAdd(@Param("videoId") long videoId);

    @Update("update video_info set video_state = #{videoState} where video_id = #{videoId}")
    Boolean auditingVideo(VideoEntity video);

    @Update("update video_info set video_score = #{videoScore} where video_id = #{videoId}")
    Boolean updateVideoScore(VideoEntity video);

}
