package com.sClass.controller;

import com.sClass.entity.*;
import com.sClass.service.*;
import com.sClass.util.ImageCode;
import com.sClass.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("student")
public class  StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GrouService grouService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private CityService cityService;
    @Autowired
    private TagService tagService;
    @RequestMapping("findAll")
    public String findAll(Model model,HttpServletRequest request){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        List<Grou> grous = grouService.findAll();
        request.getSession().setAttribute("grous",grous);
        List<Clazz> clazzes = clazzService.findAll();
        request.getSession().setAttribute("clazzes",clazzes);
        List<City> cities = cityService.findAll();
        request.getSession().setAttribute("cities",cities);
        List<Tag> tags = tagService.findAll();
        request.getSession().setAttribute("tags",tags);
        return "back/student/index";
    }
    @RequestMapping("save")
    public String save(Student student){
        studentService.save(student);
        return "redirect:/student/findAll";
    }
    @RequestMapping("login")
    public void login(Student student, HttpServletRequest request, HttpServletResponse response,String code){
        Map<String,Object> result = new HashMap<>();
        try {
            String sessionCode = (String) request.getSession().getAttribute("code");
            if(sessionCode.equalsIgnoreCase(code)) {
                Student student1 = studentService.login(student);
                request.getSession().setAttribute("student1", student);
                result.put("success", true);
            }else {
                throw new RuntimeException("验证码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("message",e.getMessage());
        }
        JSONUtils.writeToResponse(result,response);
    }
    //生成验证码
    @RequestMapping("imageCode")
    public void imageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = new ImageCode();
        //生成图片
        BufferedImage image = imageCode.getImage();
        //获取验证码
        String code = imageCode.getText();
        //将验证码放入session
        request.getSession().setAttribute("code",code);
        //设置响应类型
        response.setContentType("image/png");
        //响应图片
        ImageIO.write(image,"PNG",response.getOutputStream());
    }
    @RequestMapping("find")
    public String find (Model model,HttpServletRequest request,String id) {
        Student s = studentService.find(id);
        request.getSession().setAttribute("student",s);
        return "back/student/update";
    }
    @RequestMapping("findOne")
    public String findOne (Model model,HttpServletRequest request,String id) {
        Student s = studentService.find(id);
        request.getSession().setAttribute("student",s);
        return "back/student/detail";
    }
    @RequestMapping("update")
    public String update (Student student) {
        studentService.update(student);
        return "redirect:/student/findAll";
    }
   @RequestMapping("delete")
    public String delete(String id){
        studentService.delete(id);
        return"redirect:/student/findAll";
   }

}
