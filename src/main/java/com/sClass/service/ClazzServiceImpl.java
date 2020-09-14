package com.sClass.service;

import com.sClass.dao.ClazzDao;
import com.sClass.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("clazzService")
@Transactional
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzDao clazzDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Clazz> findAll() {

        return clazzDao.findAll();
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setId(UUID.randomUUID().toString());
        clazzDao.save(clazz);
    }
}
