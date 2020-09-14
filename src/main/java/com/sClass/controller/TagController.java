package com.sClass.controller;

import com.sClass.entity.Tag;
import com.sClass.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("tag")
public class TagController {
    @Autowired
    private TagService tagService;
    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tags",tags);

        return "back/tag/index";
    }
    @RequestMapping("save")
    public String save(Tag tag){
        tagService.save(tag);
        return "redirect:/tag/findAll";
    }

}
