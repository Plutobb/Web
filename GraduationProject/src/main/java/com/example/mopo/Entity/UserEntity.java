package com.example.mopo.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_info")
public class UserEntity {

    @TableField("userID")
    private long userId;

    @TableField("userName")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("userIntroduce")
    private String userIntroduce;

    @TableField("userAge")
    private int userAge;

    @TableField("fansCount")
    private long fansCount;

    @TableField("followCount")
    private long followCount;

    @TableField("userNum")
    private long userNum;

    @TableField("headImage")
    private String headImage;

    @TableField("tag")
    private String tag;

    @TableField(exist = false)
    private String userLoginInfo;
}
