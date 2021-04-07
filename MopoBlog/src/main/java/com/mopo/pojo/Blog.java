package com.mopo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private Long id;
    private String content;
    private String description;
    private String firstpicture;
    private String flag;
    private String title;

    private boolean appreciation;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean published;
    private boolean recommend;

    private Date create_time;
    private Date update_time;

    private Integer views;
    private Integer typeId;
    private Integer userId;



}
