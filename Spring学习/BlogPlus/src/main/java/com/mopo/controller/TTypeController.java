package com.mopo.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mopo.entity.TBlog;
import com.mopo.entity.TType;
import com.mopo.service.TBlogService;
import com.mopo.service.TTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    TBlogService blogService;

    @Autowired
    TTypeService typeService;

    @GetMapping("/types/{id}")
    public String typeFind(@PathVariable("id") Long id, Model model){
        List<TType> types= typeService.list();
        if (id == -1) {
            id = types.get(0).getId();
        }
        QueryWrapper<TBlog> wrapper = new QueryWrapper<>();
        wrapper.eq("type_id",id);
        List<TBlog> typeBlogList = blogService.list(wrapper);
        model.addAttribute("types", types);
        model.addAttribute("page",typeBlogList);
        model.addAttribute("activeTypeId", id);
        model.addAttribute("blogsListSize",typeBlogList.size());
        return "types";
    }
}

