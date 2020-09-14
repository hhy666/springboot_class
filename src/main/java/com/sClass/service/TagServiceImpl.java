package com.sClass.service;

import com.sClass.dao.Tagdao;
import com.sClass.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("tagService")
@Transactional
public class TagServiceImpl implements TagService {
    @Autowired
    private Tagdao tagdao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Tag> findAll() {

        return tagdao.findAll();

    }

    @Override
    public void save(Tag tag) {
        tag.setId(UUID.randomUUID().toString());
        tag.setCreatdate(new Date());
        tagdao.save(tag);
    }
}
