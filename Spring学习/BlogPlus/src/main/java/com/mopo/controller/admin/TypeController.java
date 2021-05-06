package com.mopo.controller.admin;

import com.mopo.entity.TType;
import com.mopo.impl.TTypeServiceImpl;
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
public class TypeController {

    @Autowired
    TTypeServiceImpl typeService;

    @Autowired
    RedisTemplate<String,String> redisTemplate;



    @GetMapping("/types")
    public String type(Model model){
        List<TType> typesList = typeService.list();
        model.addAttribute("types",typesList);
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String typeInput(Model model){
        TType type = new TType();
        model.addAttribute("type",type);
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String typesInput(TType type, RedirectAttributes redirectAttributes){
        //type新增提交
        if (type != null) {
            boolean save = typeService.save(type);
            //数据库新增之后删除redis中的缓存;
            redisTemplate.delete("types");
            if (save){
                redirectAttributes.addFlashAttribute("message","新增成功!");
            }else {
                redirectAttributes.addFlashAttribute("message","新增失败");
            }
        }
        return "redirect:/admin/types";
    }

    @GetMapping("types/{id}/delete")
    public String typesDelete(@PathVariable int id,RedirectAttributes redirectAttributes){
        boolean remove = typeService.removeById(id);
        redisTemplate.delete("types");
        if (remove){
            redirectAttributes.addFlashAttribute("message","删除成功!");
        }else {
            redirectAttributes.addFlashAttribute("message","删除失败");
        }
        return "redirect:/admin/types";
    }

}
