package com.sClass.controller;

import com.sClass.entity.Clazz;
import com.sClass.entity.Grou;
import com.sClass.service.ClazzService;
import com.sClass.service.GrouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("grou")
public class GrouController {
    @Autowired
    private GrouService grouService;
    @Autowired
    private ClazzService clazzService;
    @RequestMapping("findAll")
    public String findAll(Model model, HttpServletRequest request){
        List<Grou> grous = grouService.findAll();
        model.addAttribute("grous",grous);
        List<Clazz> clazzes = clazzService.findAll();
        request.getSession().setAttribute("clazzes",clazzes);
        return "back/group/index";
    }
    @RequestMapping("save")
    public String save(Grou grou){
        grouService.save(grou);
        return "redirect:/grou/findAll";
    }
}
