package com.sClass.service;

import com.sClass.dao.GrouDao;
import com.sClass.entity.Grou;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("grouService")
@Transactional
public class GrouServiceImpl implements GrouService {
    @Autowired
   private  GrouDao grouDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Grou> findAll() {
        return grouDao.findAll();
    }

    @Override
    public void save(Grou grou) {
      grou.setId(UUID.randomUUID().toString());
      grou.setCreatdate(new Date());
      grouDao.save(grou);
    }
}
