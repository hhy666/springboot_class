package com.sClass.controller;

import com.sClass.entity.Clazz;
import com.sClass.entity.Tag;
import com.sClass.service.ClazzService;
import com.sClass.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private TagService tagService;
    @RequestMapping("findAll")
    public String findAll(Model model, HttpServletRequest request){
        List<Clazz> clazzes = clazzService.findAll();
        model.addAttribute("clazzes",clazzes);
        List<Tag> tags = tagService.findAll();
        request.getSession().setAttribute("tags",tags);
        return "back/clazz/index";
    }
    @RequestMapping("save")
    public String save(Clazz clazz){
        clazzService.save(clazz);
        return "redirect:/clazz/findAll";
    }

}
