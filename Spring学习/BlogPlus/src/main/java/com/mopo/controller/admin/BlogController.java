package com.mopo.controller.admin;

import com.mopo.entity.TBlog;
import com.mopo.entity.TType;
import com.mopo.impl.TTypeServiceImpl;
import com.mopo.mapper.TBlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    private TBlogMapper blogMapper;

    @Autowired
    private TTypeServiceImpl typeService;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    //查询博客
    @GetMapping("/blogs")
    public String  adminIndex(Model model){
        List<TBlog> allTBlogs = blogMapper.selectList(null);
        model.addAttribute("page", allTBlogs);
        return "admin/blogs";
    }

    //新增博客页面
    @GetMapping("/blogs/input")
    public String inputBlog(Model model){
        //进入新增博客页面
        List<TType> types = typeService.list();
        model.addAttribute("blog", new TBlog());
        model.addAttribute("types",types);
        return "admin/blog-input";
    }

    //新增博客
    @PostMapping("/blogs")
    public String insertBlog(TBlog blog, RedirectAttributes redirectAttributes){
        if (blog != null){
            System.out.println(blog.getTypeId());
            int  b = blogMapper.insert(blog);
            redisTemplate.delete("types");
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
    public String deleteBlog(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Integer b = blogMapper.deleteById(id);
        redisTemplate.delete("types");
        redirectAttributes.addFlashAttribute("message","删除成功!");
        return "redirect:/admin/blogs";
    }


    //修改博客
    @GetMapping("/blogs/{id}/input")
    public String inputBlog(@PathVariable Long id,Model model){
        TBlog blog = blogMapper.selectById(id);
        redisTemplate.delete("types");
        model.addAttribute("blog",blog);
        return "admin/blog-input";
    }
}
