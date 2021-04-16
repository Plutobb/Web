package com.mopo.mabatis;

import com.mopo.mabatis.mapper.TBlogMapper;
import com.mopo.mabatis.mapper.UserMapper;
import com.mopo.mabatis.pojo.TBlog;
import com.mopo.mabatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class MopoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TBlogMapper tBlogMapper;

    @Test
    void contextLoads() {
        List<TBlog> tBlogs = tBlogMapper.selectList(null);
        tBlogs.forEach(System.out::println);
    }

}
