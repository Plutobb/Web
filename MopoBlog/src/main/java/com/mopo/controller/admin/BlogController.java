package com.mopo.controller.admin;

import com.mopo.mapper.BlogMapper;
import com.mopo.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    @GetMapping("/blogs")
    public String  adminIndex(Model model){
        List<Blog> allBlogs = blogMapper.findAll();
        System.out.println(allBlogs);
        model.addAttribute("page",allBlogs);
        return "admin/blogs";
    }

    @GetMapping("/blogs/input")
    public String inputBlog(Model model){
        Model blog = model.addAttribute("blog", new Blog());
        System.out.println(blog);
        return "admin/blog-input";
    }
}
