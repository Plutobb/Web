package com.mopo.controller;

import com.mopo.mapper.BlogMapper;
import com.mopo.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogMapper BlogMapper;

    @GetMapping("/index")
    public String index(Model model){
        List<Blog> allBlog = BlogMapper.findAll();
        for (Blog blog : allBlog) {
            System.out.println(blog);
        }
        model.addAttribute("page",allBlog);

        System.out.println("-----------------------------");
        return "index";
    }

}
