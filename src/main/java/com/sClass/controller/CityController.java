package com.sClass.controller;

import com.sClass.entity.City;
import com.sClass.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;
    @RequestMapping("findAll")
    public String findAll(Model model){
        List<City> cities = cityService.findAll();
        model.addAttribute("cities",cities);
        return "back/city/index";
    }
    @RequestMapping("save")
    public String save(City city){
        cityService.save(city);
        return "redirect:/city/findAll";
    }
}
