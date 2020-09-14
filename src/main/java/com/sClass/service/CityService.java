package com.sClass.service;

import com.sClass.entity.City;

import java.util.List;

public interface CityService {
    List<City> findAll();
    void save(City city);
}
