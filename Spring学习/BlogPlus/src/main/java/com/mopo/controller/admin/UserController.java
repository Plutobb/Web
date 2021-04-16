package com.mopo.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mopo.entity.TUser;
import com.mopo.mapper.TUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private TUserMapper userMapper;

    @GetMapping
    public String login(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String loginBlog(Model model,
                            @RequestParam String username,
                            @RequestParam String password,
                            HttpSession session,
                            RedirectAttributes attributes){
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username)
                .eq("password",password);
        TUser admin =userMapper.selectOne(wrapper);
        session.setAttribute("user",admin);
        if (admin != null){
            System.out.println(admin);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }

}
