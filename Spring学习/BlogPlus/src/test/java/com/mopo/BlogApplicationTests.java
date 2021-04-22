package com.mopo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mopo.entity.TBlog;
import com.mopo.entity.TType;
import com.mopo.entity.TUser;
import com.mopo.mapper.TBlogMapper;
import com.mopo.mapper.TTypeMapper;
import com.mopo.mapper.TUserMapper;
import com.mopo.service.TTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private TBlogMapper blogMapper;

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TTypeMapper typeMapper;

    @Autowired
    TTypeService typeService;
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
//        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
//        wrapper.eq("type_id",1);
//        TBlog tBlog = blogMapper.selectOne(wrapper);
//        System.out.println(tBlog);

        List<TType> types = typeService.list();
        Long id = types.get(0).getId();
        System.out.println(id);
        types.forEach(System.out::println);
    }

}
