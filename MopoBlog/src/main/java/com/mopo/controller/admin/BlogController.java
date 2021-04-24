package com.mopo.controller.admin;

import com.mopo.mapper.BlogMapper;
import com.mopo.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;


    //查询博客
    @GetMapping("/blogs")
    public String  adminIndex(Model model){
        List<Blog> allBlogs = blogMapper.findAll();
        model.addAttribute("page",allBlogs);
        return "admin/blogs";
    }

    //新增博客页面
    @GetMapping("/blogs/input")
    public String inputBlog(Model model){
        //进入新增博客页面
        Model blog = model.addAttribute("blog", new Blog());
        return "admin/blog-input";
    }

    //新增博客
    @PostMapping("/blogs")
    public String insertBlog(Blog blog,RedirectAttributes redirectAttributes){
        if (blog != null){
            Integer b = blogMapper.insertBlog(blog);
            if (b == 1){
                redirectAttributes.addFlashAttribute("message","新增成功!");
            }else {
                redirectAttributes.addFlashAttribute("message","新增失败");
            }
        }
        return "redirect:/admin/blogs";
    }

    //删除博客
    @RequestMapping("/blogs/{id}/delete")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes redirectAttributes,Model model){
        Integer b = blogMapper.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message","删除成功!");
        return "redirect:/admin/blogs";
    }


    //修改博客
    @GetMapping("/blogs/{id}/input")
    public String inputBlog(@PathVariable Long id,Model model){
        Blog blog = blogMapper.findById(id);
        model.addAttribute("blog",blog);
        return "admin/blog-input";
    }


}
