package com.sClass.service;

import com.sClass.entity.Clazz;

import java.util.List;

public interface ClazzService {
    List<Clazz> findAll();
    void save (Clazz clazz);
}
