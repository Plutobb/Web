package mopo.demo;

import mopo.demo.Pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Test
    void redisTest(){
        redisTemplate.delete("name");
        redisTemplate.opsForList().leftPush("name","zhb");
        redisTemplate.opsForList().leftPush("name","cjj");
        redisTemplate.opsForList().leftPush("name","wo");
        redisTemplate.opsForList().leftPush("name","ai");
        System.out.println(redisTemplate.opsForList().range("name", 0, -1));
    }


}
