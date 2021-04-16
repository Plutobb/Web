package com.mopo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mopo.BlogApplication;
import com.mopo.entity.TBlog;
import com.mopo.mapper.TBlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
public class TBlogController {

    @Autowired
    private TBlogMapper blogMapper;

    @GetMapping("")
    public String index(Model model){
        List<TBlog> allBlogs = blogMapper.selectList(null);
        model.addAttribute("page",allBlogs);
        return "index";
    }

    @GetMapping("{page}/{size}")
    public String indexPage(Model model,@PathVariable("page") int page,@PathVariable("size") int size){
        System.out.println(page+"-"+size);
        Page<TBlog> pageBlog = new Page<>(page, size);
        Page<TBlog> tBlogPage = blogMapper.selectPage(pageBlog, null);
        List<TBlog> listBlog = tBlogPage.getRecords();
        System.out.println("listBlog"+listBlog);
        model.addAttribute("page",listBlog);
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String blogById(@PathVariable("id")Long id, Model model){
        TBlog blog = blogMapper.selectById(id);
        System.out.println(blog);
        model.addAttribute("blog",blog);
        return "blog";
    }


    @PostMapping("/search")
    public String searchBlog(Model model, @RequestParam String query){
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        wrapper.like("title", query);
        List<TBlog> searchBlog = blogMapper.selectList(wrapper);
        model.addAttribute("page",searchBlog);
        return "search";
    }
}

