package com.sClass.service;

import com.sClass.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    public List<Student> findAll();
    public void save(Student student);
    public Student login(Student student);
    public  Student find(String id);
    public void update( Student student);
    public void delete(String id);
}
