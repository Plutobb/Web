package com.example.mopo.ScheduledTask;

import com.example.mopo.Common.Result;
import com.example.mopo.Entity.VideoEntity;
import com.example.mopo.Service.Impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@EnableScheduling
public class ScheduledTask {

    @Autowired
    private VideoServiceImpl videoServiceImpl;

    @Scheduled(fixedRate = 1000L*60*10)
    public void getVideoScore() {
        Result result = videoServiceImpl.getHotVideos();
        List<VideoEntity> videos = (List<VideoEntity>) result.getData();
        videos.forEach(video->{
            video.setVideoScore(video.getVideoStar()+video.getVideoPlayNum()+video.getVideoStar()+video.getVideoUpNum());
            videoServiceImpl.updateVideoScore(video);
        });
    }
}
