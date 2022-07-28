package com.example.mopo.Controller;

import com.example.mopo.Common.Result;
import com.example.mopo.Entity.UserEntity;
import com.example.mopo.Entity.UserUpEntity;
import com.example.mopo.Entity.VideoEntity;
import com.example.mopo.Service.Impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Controller
public class VideoController {

    @Autowired
    private VideoServiceImpl videoServiceImpl;

    @ResponseBody
    @GetMapping("/video/{videoId}")
    public Result getVideo(@PathVariable long videoId){
        return videoServiceImpl.selectVideo(videoId);
    }

    @ResponseBody
    @GetMapping("/video/search/{searchInput}")
    public Result getVideoBySearch(@PathVariable String searchInput){
        return videoServiceImpl.selectVideoBySearch(searchInput);
    }

    @ResponseBody
    @GetMapping("/video/type/{type}")
    public Result getVideoByType(@PathVariable String type){
        return videoServiceImpl.selectVideoByType(type);
    }

    @ResponseBody
    @PostMapping("/video/upload")
    public Result uploadVideo(MultipartFile file,String title,String tag,String type,String introduce,long userId) throws Exception {
        return videoServiceImpl.upload(file, title, tag,type, introduce, userId);
    }

    @ResponseBody
    @PostMapping("/video/getVideoInfo")
    public Result getVideoInfo(@RequestBody UserEntity user){
        return videoServiceImpl.selectVideosByUserId(user.getUserId());
    }

    @ResponseBody
    @PostMapping("/video/getAllVideo")
    public Result getAllVideo(@RequestBody UserEntity user){
        return videoServiceImpl.selectAllVideosByUserId(user.getUserId());
    }

    @ResponseBody
    @PostMapping("/video/getAllUserVideo")
    public Result getAllUserVideo(@RequestBody UserEntity user){
        return videoServiceImpl.selectAllUserVideos();
    }

    @ResponseBody
    @PostMapping("/video/getReleaseVideoInfo")
    public Result getReleaseVideoInfo(@RequestBody UserEntity user){
        return videoServiceImpl.selectReleaseVideosByUserId(user.getUserId());
    }

    @ResponseBody
    @PostMapping("/video/getReleaseVideoInfoAdmin")
    public Result getReleaseVideoInfoAdmin(@RequestBody UserEntity user){
        return videoServiceImpl.selectReleaseVideosAdmin(user.getUserId());
    }

    @ResponseBody
    @PostMapping("/video/getAuditingVideoInfo")
    public Result getAuditingVideoInfo(@RequestBody UserEntity user){
        return videoServiceImpl.selectAuditingVideosByUserId(user.getUserId());
    }

    @ResponseBody
    @PostMapping("/video/getAuditingVideoInfoAdmin")
    public Result getAuditingVideoInfoAdmin(@RequestBody UserEntity user){
        return videoServiceImpl.selectAuditingVideosAdmin(user.getUserId());
    }

    @ResponseBody
    @PostMapping("/video/getFailVideoInfo")
    public Result getFailVideoInfo(@RequestBody UserEntity user){
        return videoServiceImpl.selectFailVideosByUserId(user.getUserId());
    }

    @ResponseBody
    @PostMapping("/video/getFailVideoInfoAdmin")
    public Result getFailVideoInfoAdmin(@RequestBody UserEntity user){
        return videoServiceImpl.selectFailVideosAdmin(user.getUserId());
    }

    @ResponseBody
    @PostMapping("/video/deleteVideo")
    public Result deleteVideo(@RequestBody VideoEntity video){
        return videoServiceImpl.deleteVideo(video.getVideoId());
    }

    @ResponseBody
    @PostMapping("/video/auditingVideo")
    public Result auditingVideo(@RequestBody VideoEntity video){
        return videoServiceImpl.auditingVideo(video);
    }

    @ResponseBody
    @PostMapping("/video/getHotVideo")
    public Result getHotVideo(){
        return videoServiceImpl.getHotVideos();
    }

    @ResponseBody
    @PostMapping("/video/upVideo")
    public Result upVideo(@RequestBody UserUpEntity userUp){
        return videoServiceImpl.upVideo(userUp);
    }

    @ResponseBody
    @PostMapping("/video/delUpVideo")
    public Result delUpVideo(@RequestBody UserUpEntity userUp){
        return videoServiceImpl.delUpVideo(userUp);
    }

    @ResponseBody
    @PostMapping("/video/isUp")
    public Result isUp(@RequestBody UserUpEntity userUp){
        return videoServiceImpl.judgeIsUpVideo(userUp);
    }

    @ResponseBody
    @PostMapping("/video/getVideoByTags")
    public Result recommendVideo(@RequestBody UserEntity user){
       return  videoServiceImpl.selectVideoByTags(user);
    }

}
