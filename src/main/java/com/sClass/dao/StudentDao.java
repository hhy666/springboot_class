package com.sClass.dao;

import com.sClass.entity.Student;

public interface StudentDao extends BaseDao<Student> {
    public Student login(String username);
}
