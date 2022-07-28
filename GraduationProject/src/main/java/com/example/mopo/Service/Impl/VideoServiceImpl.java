package com.example.mopo.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mopo.Common.Result;
import com.example.mopo.Entity.Enum.IsDelete;
import com.example.mopo.Entity.Enum.VideoState;
import com.example.mopo.Entity.UserEntity;
import com.example.mopo.Entity.UserUpEntity;
import com.example.mopo.Entity.VideoEntity;
import com.example.mopo.Mapper.VideoMapper;
import com.example.mopo.Service.VideoService;
import com.example.mopo.Utils.JSONUtils;
import com.example.mopo.Utils.SimilarityUtil;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, VideoEntity> implements VideoService {

    @Value("${video.upload.path}")
    private String videoUploadPath;

    @Value("${image.upload.path}")
    private String imageUploadPath;

    @Value("${video.url}")
    private String videoUrl;

    @Value("${image.url}")
    private String imageUrl;

    @Autowired
    private VideoMapper videoMapper;


    public Result upload(MultipartFile file, String title,String tag,String type, String introduce, long userId) throws Exception {
        File uploadParentFile = new File(videoUploadPath);
        if (!uploadParentFile.exists()){
            uploadParentFile.mkdirs();
        }
        String uuid = UUID.randomUUID().toString().replace("-", "");
        File uploadFile = new File(videoUploadPath + uuid + ".mp4");
        file.transferTo(uploadFile);

        //获取视频第一帧图片作为封面
        String videoFirstImg = getVideoFirstImg(videoUploadPath+uuid+".mp4",uuid);
        //存储到数据库
        VideoEntity videoEntity = new VideoEntity();
        videoEntity.setUserId(userId);
        videoEntity.setVideoTitle(title);
        videoEntity.setVideoIntroduce(introduce);
        videoEntity.setVideoType(type);
        videoEntity.setVideoUrl(videoUrl+uuid+".mp4");
        videoEntity.setVideoImage(imageUrl+uuid+".jpg");

        String[] tags = tag.split("，");
        HashMap<String, Double> tagsMap = new HashMap<>();
        for (String s : tags) {
            tagsMap.put(s,1.0);
        }
        videoEntity.setVideoTag(JSONUtils.beanToJson(tagsMap));

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        videoEntity.setVideoUploadTime(sdf.format(System.currentTimeMillis()));
        int save = videoMapper.insert(videoEntity);
        Result result = new Result();
        if (save>0){
            result.setCode(200);
            result.setMsg("发布成功");
        }else {
            result.setCode(401);
            result.setMsg("发布失败");
        }
        return result;
    }

    public Result selectVideo(long videoId){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("video_id",videoId);
        Result result = new Result();
        VideoEntity videoEntity = videoMapper.selectOne(queryWrapper);
        if (videoEntity != null){
            //在这里对视频播放量加一
            videoMapper.playNumAdd(videoId);
            result.setCode(200);
            result.setData(videoEntity);
        }else {
            result.setCode(555);
            result.setMsg("获取视频信息失败！");
        }
        return result;
    }

    //获取已经发布视频
    public Result selectReleaseVideosByUserId(long userId){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("video_is_delete", IsDelete.NO_DELETE.getValue()).eq("video_state", VideoState.RELEASE.getValue());
        List<VideoEntity> list = videoMapper.selectList(queryWrapper);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    //管理员获取已经发布视频
    public Result selectReleaseVideosAdmin(long userId){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("video_is_delete", IsDelete.NO_DELETE.getValue()).eq("video_state", VideoState.RELEASE.getValue());
        List<VideoEntity> list = videoMapper.selectList(queryWrapper);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    //获取审核中视频
    public Result selectAuditingVideosByUserId(long userId){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("video_is_delete", IsDelete.NO_DELETE.getValue()).eq("video_state", VideoState.AUDITING.getValue());
        List<VideoEntity> list = videoMapper.selectList(queryWrapper);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    //管理员获取审核中视频
    public Result selectAuditingVideosAdmin(long userId){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("video_is_delete", IsDelete.NO_DELETE.getValue()).eq("video_state", VideoState.AUDITING.getValue());
        List<VideoEntity> list = videoMapper.selectList(queryWrapper);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    //获取审核失败视频
    public Result selectFailVideosByUserId(long userId){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("video_is_delete", IsDelete.NO_DELETE.getValue()).eq("video_state", VideoState.FAIL.getValue());
        List<VideoEntity> list = videoMapper.selectList(queryWrapper);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    //管理员获取审核失败视频
    public Result selectFailVideosAdmin(long userId){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("video_is_delete", IsDelete.NO_DELETE.getValue()).eq("video_state", VideoState.FAIL.getValue());
        List<VideoEntity> list = videoMapper.selectList(queryWrapper);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    //按照搜索内容查询
    public Result selectVideoBySearch(String searchInput){
        List<VideoEntity> videosBySearch = videoMapper.getVideosBySearch(searchInput);
        Result result = new Result();
        result.setCode(200);
        result.setData(videosBySearch);
        return result;
    }
    //按照视频类型查询
    public Result selectVideoByType(String type){
        List<VideoEntity> list = videoMapper.getVideosByType(type);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    //审核视频
    public Result auditingVideo(VideoEntity video){
        Boolean aBoolean = videoMapper.auditingVideo(video);
        Result result = new Result();
        if (aBoolean){
            result.setCode(200);
        }else {
            result.setCode(500);
            result.setMsg("审核失败！");
        }
        return result;
    }

    //跟具标签获取推荐视频
    public Result selectVideoByTags(UserEntity user){
        //获取用户的爱好标签
        HashMap<String, Double> userTags = JSON.parseObject(user.getTag(),new TypeReference<HashMap<String, Double>>() {});
        //对所有视频进行余弦相似度计算
        List<VideoEntity> allVideos = videoMapper.getAllVideos();
        allVideos.forEach(video -> {
            if (video.getVideoTag()!=null) {
                HashMap<String, Double> videoTags = JSON.parseObject(video.getVideoTag(),new TypeReference<HashMap<String, Double>>() {});
                if (!videoTags.isEmpty()) {
                    ArrayList<Double> userScore = new ArrayList<>();
                    ArrayList<Double> videoScore = new ArrayList<>();
                    for (Map.Entry<String, Double> userTag : userTags.entrySet()) {
                        userScore.add(userTag.getValue());
                        videoScore.add(videoTags.getOrDefault(userTag.getKey(), 0.0));
                    }
                    double similarity = SimilarityUtil.similarity(userScore, videoScore);
                    if (!Double.isNaN(similarity)){
                        video.setSimilarity(similarity);
                    }else {
                        video.setSimilarity(0.0);
                    }
                }
            }
        });
        List<VideoEntity> recommendVideo = allVideos.stream().sorted(Comparator.comparing(VideoEntity::getSimilarity).reversed()).collect(Collectors.toList());
        Result result = new Result();
        result.setCode(200);
        result.setData(recommendVideo);
        return result;
    }

    public Result selectVideosByUserId(long userId){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("video_is_delete", IsDelete.NO_DELETE.getValue());
        queryWrapper.eq("video_state",VideoState.RELEASE.getValue());
        List<VideoEntity> list = videoMapper.selectList(queryWrapper);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    public Result selectAllVideosByUserId(long userId){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("video_is_delete", IsDelete.NO_DELETE.getValue());
        List<VideoEntity> list = videoMapper.selectList(queryWrapper);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }

    public Result selectAllUserVideos(){
        QueryWrapper<VideoEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("video_is_delete", IsDelete.NO_DELETE.getValue());
        List<VideoEntity> list = videoMapper.selectList(queryWrapper);
        Result result = new Result();
        result.setCode(200);
        result.setData(list);
        return result;
    }


    public Result deleteVideo(long videoId) {
        Result result = new Result();
        if (videoMapper.deleteVideo(videoId)){
            result.setCode(200);
            result.setMsg("删除成功！");
        }else {
            result.setCode(501);
            result.setMsg("删除失败！");
        }
        return result;
    }

    //获取热点视频
    public Result getHotVideos(){
        List<VideoEntity> hotVideos = videoMapper.getHotVideos();
        Result result = new Result();
        if (!hotVideos.isEmpty()){
            result.setCode(200);
            result.setData(hotVideos);
        }else {
            result.setCode(501);
            result.setMsg("获取热点视频失败！");
        }
        return result;
    }

    //获取视频封面
    public String getVideoFirstImg(String path,String uuid)throws Exception {
        Frame frame = null;
        //构造器支持InputStream，可以直接传MultipartFile.getInputStream()
        FFmpegFrameGrabber fFmpegFrameGrabber = new FFmpegFrameGrabber(path);
        //开始播放
        fFmpegFrameGrabber.start();
        //获取视频总帧数
        int ftp = fFmpegFrameGrabber.getLengthInFrames();
        //指定第几帧
        fFmpegFrameGrabber.setFrameNumber(5);
        //获取指定第几帧的图片
        frame = fFmpegFrameGrabber.grabImage();
        //文件绝对路径+名字

        String fileName = imageUploadPath+uuid+".jpg";
        File outPut = new File(fileName);
        if (!outPut.exists()){
            outPut.mkdirs();
        }
        ImageIO.write(FrameToBufferedImage(frame), "jpg", outPut);
        return fileName;
    }

    //更新视频的分数
    public Boolean updateVideoScore(VideoEntity video) {
        return videoMapper.updateVideoScore(video);
    }

    public BufferedImage FrameToBufferedImage(Frame frame) {
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bufferedImage = converter.getBufferedImage(frame);
        return bufferedImage;
    }

    public Result upVideo(UserUpEntity userUp){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userUp.setUpTime(sdf.format(System.currentTimeMillis()));
        Result result = new Result();
        if (isUp(userUp.getUserId(),userUp.getVideoId()).isEmpty()){
            //如果没点赞就插入
            if (insertUserUp(userUp)){
                if (videoMapper.upVideo(userUp.getVideoId())){
                    result.setCode(200);
                    result.setData("点赞成功！");
                }else {
                    result.setCode(501);
                    result.setMsg("点赞失败！");
                }
            }
        }else {
            result.setCode(502);
            result.setMsg("已经点过赞！");
        }
        return result;
    }

    public Result delUpVideo(UserUpEntity userUp){
        Result result = new Result();
        if (videoMapper.delUserUp(userUp)){
            if (videoMapper.downVideo(userUp.getVideoId())){
                result.setCode(200);
                result.setMsg("取消点赞成功！");
            }
        }else{
            result.setCode(503);
            result.setMsg("取消点赞失败！");
        }
        return result;
    }

    public List<UserUpEntity> isUp(long userId,long videoId){
        return videoMapper.isUp(userId,videoId);
    }

    public Boolean insertUserUp(UserUpEntity userUp){
        return videoMapper.insertUserUp(userUp);
    }

    public Result judgeIsUpVideo(UserUpEntity userUp){
        List<UserUpEntity> up = isUp(userUp.getUserId(), userUp.getVideoId());
        Result result = new Result();
        if (up.isEmpty()){
            result.setCode(200);
            result.setMsg("没点过赞！");
        }else {
            result.setCode(502);
            result.setMsg("已经点过赞！");
        }
        return result;
    }
}
