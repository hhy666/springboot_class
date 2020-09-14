package com.sClass.service;

import com.sClass.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAll();
    void save(Tag tag);
}
