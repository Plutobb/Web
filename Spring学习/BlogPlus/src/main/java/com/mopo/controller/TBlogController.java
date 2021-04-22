package com.mopo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mopo.BlogApplication;
import com.mopo.entity.TBlog;
import com.mopo.mapper.TBlogMapper;
import com.mopo.service.TBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.LinkedList;
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
    private TBlogService blogService;

    @GetMapping("")
    public String index(Model model){
        List<TBlog> allBlogs = blogService.list();
        model.addAttribute("page",allBlogs);
        return "index";
    }

    @GetMapping("{page}/{size}")
    public String indexPage(Model model,@PathVariable("page") int page,@PathVariable("size") int size){
        System.out.println(page+"-"+size);
        Page<TBlog> pageBlog = new Page<>(page, size);
        //Page<TBlog> tBlogPage = blogMapper.selectPage(pageBlog, null);
        Page<TBlog> blogPage = blogService.selectPage(pageBlog);
        List<TBlog> listBlog = blogPage.getRecords();
        System.out.println("listBlog"+listBlog);
        model.addAttribute("page",listBlog);
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String blogById(@PathVariable("id") Long id, Model model){
        TBlog blog = blogService.selectById(id);
        System.out.println(blog);
        model.addAttribute("blog",blog);
        return "blog";
    }


    @PostMapping("/search")
    public String searchBlog(Model model, @RequestParam String query){
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        wrapper.like("title", query);
        List<TBlog> searchBlog = blogService.list(wrapper);
        model.addAttribute("page",searchBlog);
        return "search";
    }

    @GetMapping("/footer/newblog")
    public String footerNewBlog(Model model){
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        Page<TBlog> pageNewBlogs = new Page<>(1,3);
        List<TBlog> newBlogs  = blogService.selectPage(pageNewBlogs, wrapper).getRecords();
        model.addAttribute("newblogs",newBlogs);
        return "_fragments :: newblogList";
    }
}

