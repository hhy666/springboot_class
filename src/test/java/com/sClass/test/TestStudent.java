package com.sClass.test;

import com.sClass.entity.*;
import com.sClass.service.CityService;
import com.sClass.service.StudentService;
import com.sClass.service.TagService;
import com.sClass.util.XMLUtil;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class TestStudent extends Basic {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CityService cityService;
    @Autowired
    private TagService tagService;
    @Test
    public void findAll() throws  Exception{
        JAXBContext context = JAXBContext.newInstance(Student.class);    // 获取上下文对象
        Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进
        for(int i = 0;i<getSimpleStudent().size();i++) {
            marshaller.marshal(getSimpleStudent().get(i), System.out);   // 打印到控制台
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for(int i = 0;i<getSimpleStudent().size();i++) {
            marshaller.marshal(getSimpleStudent().get(i), baos);
        }
        for(int i = 0;i<getSimpleStudent().size();i++) {
            String path = "E:\\erlOrRabbitmq\\2\\city"+i+".xml";
            XMLUtil.convertToXml(getSimpleStudent().get(i), path);
        }
        String xmlObj = new String(baos.toByteArray());         // 生成XML字符串
        System.out.println(xmlObj);
    }
    private List<Student> getSimpleStudent() {
        Student student = new Student();
        List<Student>students= studentService.findAll();
//        for(int i = 0;i<students.size();i++){
//            student.setName(students.get(i).getName());
//            student.setAge(students.get(i).getAge());
//            student.setBir(students.get(i).getBir());
//           student.setTag(students.get(i).getTag());
//           student.setCity(students.get(i).getCity());
//           student.setClazz(students.get(i).getClazz());
//           student.setGrou(students.get(i).getGrou());
//        }
//        return student;
        return students;
    }

         @Test
        public void findOne (){
            Student student = studentService.find("9a35a6a3-3d68-4f64-9bfd-131a28eced68");
            System.out.println(student);
    }
    @Test
    public void update(){
        Student student = studentService.find("9a35a6a3-3d68-4f64-9bfd-131a28eced68");
        student.setAge(20);
        studentService.update(student);
        System.out.println(student);
    }
    @Test
    public  void  find1() {
        List<City> city = cityService.findAll();
        city.forEach(city1 -> System.out.println(city1));
    }
    @SneakyThrows
    @Test
    public void findAllByCity(){
        List<City>cities = cityService.findAll();
        List<Tag>tags = tagService.findAll();
        for(int i = 0;i<tags.size();i++){
            String path = "E:\\erlOrRabbitmq\\2\\city"+i+".xml";
            XMLUtil.convertToXml(tags.get(i), path);
        }
        for(int i = 0;i<cities.size();i++) {
            String path = "E:\\erlOrRabbitmq\\2\\city"+i+".xml";
                XMLUtil.convertToXml(cities.get(i), path);
        }

        //cities.forEach(city -> System.out.println(city));
//        City city = new City();
//        city.setId("22");
//        city.setName("张家界");
//        city.setCreatdate(new Date());
//        String path = "E:\\erlOrRabbitmq\\1\\city.xml";
//        JAXBContext context = JAXBContext.newInstance(city.getClass());
//        QName qName = new QName("http://ws.test.com","MainFest"," ");
//        JAXBElement<City> jaxbElement = new JAXBElement<City>(qName,City.class,city);
//
//        Marshaller marshaller = context.createMarshaller();
//        StringWriter stringWriter = new StringWriter();
//        marshaller.marshal(jaxbElement,stringWriter);
//        System.out.println(stringWriter.toString());
    }
}
