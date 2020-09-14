package com.sClass.service;

import com.sClass.dao.StudentDao;
import com.sClass.entity.Student;
import com.sClass.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements  StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void save(Student student) {
        student.setId(UUID.randomUUID().toString());
        //student.setBir(new Date());
        studentDao.save(student);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Student login(Student student) {
        Student student1 = studentDao.login(student.getUsername());
        if(student1 != null){
            if(student1.getPassword().equals(student.getPassword())){
                return student1;
            }
            throw new RuntimeException("密码错误");
        }
        throw  new RuntimeException("用户名错误");
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Student find(String id)  {
//        Student s = new Student();
//        if(id != null && id.toString()!=""){
        Student s = studentDao.find(id);
        //}
        System.out.println("-------------"+s);
        return s;
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(String id) {
       studentDao.delete(id);
    }
}
