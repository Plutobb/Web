package com.mopo.mabatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mopo.mabatis.mapper")
public class MopoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MopoApplication.class, args);
    }

}
