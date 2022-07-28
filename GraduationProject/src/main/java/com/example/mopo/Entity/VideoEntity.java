package com.example.mopo.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("video_info")
public class VideoEntity {

    private long videoId;

    private long userId;

    private String videoUploadTime;

    private String videoIntroduce;

    private String videoUrl;

    private String videoImage;

    private String videoTitle;

    private String videoType;

    private String videoTag;

    private String videoUuid;

    private long videoStar;

    private long videoUpNum;

    private long videoState;

    private long videoPlayNum;

    private long videoScore;

    @TableField(exist = false)
    private String headImage;

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private Double similarity;
}
