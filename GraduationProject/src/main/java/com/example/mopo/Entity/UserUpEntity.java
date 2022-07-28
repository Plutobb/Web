package com.example.mopo.Entity;

import lombok.Data;

@Data
public class UserUpEntity {
    private long id;
    private long userId;
    private long videoId;
    private String upTime;
}
