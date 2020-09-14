package com.sClass.service;

import com.sClass.entity.Grou;

import java.util.List;

public interface GrouService {
    List<Grou> findAll();
    void save(Grou grou);
}
