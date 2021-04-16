package com.mopo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mopo.entity.TUser;
import com.mopo.mapper.TBlogMapper;
import com.mopo.mapper.TUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private TBlogMapper mapper;

    @Autowired
    private TUserMapper userMapper;

    @Test
    void contextLoads() {
//        Page<TBlog> page = new Page<>(2, 1);
//        IPage<TBlog> tBlogIPage = mapper.selectPage(page, null);
//        List<TBlog> records = tBlogIPage.getRecords();
//        records.forEach(System.out::println);

//        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username","admin")
//                .eq("password","96e79218965eb72c92a549dd5a330112");
//
//        List<TUser> tUsers = userMapper.selectList(queryWrapper);
//        tUsers.forEach(System.out::println);
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username","admin");
        TUser tUser = userMapper.selectOne(wrapper);
        System.out.println(tUser);
    }

}
