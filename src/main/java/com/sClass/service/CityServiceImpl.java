package com.sClass.service;

import com.sClass.dao.CityDao;
import com.sClass.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("cityService")
@Transactional
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public void save(City city) {
        city.setId(UUID.randomUUID().toString());
        city.setCreatdate(new Date());
        cityDao.save(city);
    }
}
