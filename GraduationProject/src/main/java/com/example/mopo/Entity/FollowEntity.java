package com.example.mopo.Entity;

import lombok.Data;

@Data
public class FollowEntity {

    private long id;

    private long userId;

    private long followUserId;

    private String followTime;

}
