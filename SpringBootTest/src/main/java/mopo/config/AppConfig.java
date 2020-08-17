package mopo.config;

import mopo.demo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<String,String> test(){
        Map<String,String> map = new HashMap<>();
        map.put("疾风剑豪","亚索");
        map.put("封魔剑魂","永恩");
        return map;
    }
    @Bean
    public Map<String,String> test1(){
        Map<String,String> map = new HashMap<>();
        map.put("莫秃","123");
        return map;
    }
    @Bean
    public User user1(){
        User user1 = new User();
        user1.setName("莫秃");
        user1.setPassWord("123");
        return user1;
    }
}
