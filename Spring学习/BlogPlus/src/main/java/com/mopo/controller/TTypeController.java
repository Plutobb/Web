package com.mopo.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mopo.entity.TBlog;
import com.mopo.entity.TType;
import com.mopo.impl.TBlogServiceImpl;
import com.mopo.impl.TTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 莫秃
 * @since 2021-04-10
 */
@Controller
public class TTypeController {

    @Autowired
    TBlogServiceImpl blogService;

    @Autowired
    TTypeServiceImpl typeService;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

//    @GetMapping("/types/{id}")
//    public String typeFind(@PathVariable("id") Long id, Model model){
//        List<TType> types= typeService.list();
//        if (id == -1) {
//            id = types.get(0).getId();
//        }
//        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
//        wrapper.eq("type_id",id);
//        List<TBlog> typeBlogList = blogService.list(wrapper);
//        model.addAttribute("types", types);
//        model.addAttribute("page",typeBlogList);
//        model.addAttribute("activeTypeId", id);
//        model.addAttribute("blogsListSize",typeBlogList.size());
//        return "types";
//    }

    @GetMapping("/types/{id}")
    public String typeFindTest(@PathVariable("id") Long id, Model model){
        String redisTypes = redisTemplate.opsForValue().get("types");
        List<TType> types = null;
        if (redisTypes == null){
            System.out.println("进入了数据库查询!");
            //如果从缓存中查不到则去数据库查询并写入缓存
            types = typeService.getTypesAndBlogsCount();
            String typesJSON = JSON.toJSONString(types);
            redisTemplate.opsForValue().set("types",typesJSON);
        }else {
            //如果从redis中查到了就直接返回
            System.out.println("redis查到了!");
            types = JSON.parseArray(redisTypes,TType.class);
        }
        if (id == -1) {
            id = types.get(0).getId();
        }
        model.addAttribute("types", types);
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        wrapper.eq("type_id",id);
        List<TBlog> typeBlogList = blogService.selectBlogAndTypeNameById(wrapper);
        model.addAttribute("page",typeBlogList);
        model.addAttribute("activeTypeId", id);
        return "types";
    }

}

