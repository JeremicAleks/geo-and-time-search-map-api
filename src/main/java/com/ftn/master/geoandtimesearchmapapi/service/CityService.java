package com.ftn.master.geoandtimesearchmapapi.service;

import com.ftn.master.geoandtimesearchmapapi.domain.City;
import com.ftn.master.geoandtimesearchmapapi.dto.AddCityDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.CityDTO;

import java.util.List;

public interface CityService {

    List<City> findAllCities();
    City findCityById(Long id);
    City findCityByName(String name);
    City saveCity(CityDTO addCityDTO);
    City updateCity(City city);
    boolean deleteCity(Long id);
}
