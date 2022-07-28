package com.example.mopo.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("user_comment")
public class CommentEntity {

    private long id;

    private long userId;

    private String time;

    private String content;

    private long pid;

    private long originId;

    private long videoId;

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String headImage;

    @TableField(exist = false)
    private List<CommentEntity> child;

}
