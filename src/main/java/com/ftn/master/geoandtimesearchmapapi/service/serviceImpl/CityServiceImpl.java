package com.ftn.master.geoandtimesearchmapapi.service.serviceImpl;

import com.ftn.master.geoandtimesearchmapapi.domain.City;
import com.ftn.master.geoandtimesearchmapapi.dto.CityDTO;
import com.ftn.master.geoandtimesearchmapapi.service.lucene.indexing.IndexerCityService;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.IndexUnitCity;
import com.ftn.master.geoandtimesearchmapapi.service.CityService;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final IndexerCityService indexerCityService;

    public CityServiceImpl(IndexerCityService indexerCityService) {
        this.indexerCityService = indexerCityService;
    }

    @Override
    public List<City> findAllCities() {
        return null;
    }

    @Override
    public City findCityById(Long id) {
        return null;
    }

    @Override
    public City findCityByName(String name) {
        return null;
    }

    @Override
    public City saveCity(CityDTO addCityDTO) {

        IndexUnitCity index = new IndexUnitCity();
        index.setAdminName(addCityDTO.getAdminName());
        index.setCountry(addCityDTO.getCountry());
        index.setGeoPoint(new GeoPoint(addCityDTO.getLat(),addCityDTO.getLon()));
        index.setId(addCityDTO.getId().toString());
        index.setIso3(addCityDTO.getIso3());
        index.setName(addCityDTO.getName());
        index.setNameAscii(addCityDTO.getNameAscii());
        indexerCityService.addCity(index);

        return null;
    }

    @Override
    public City updateCity(City city) {
        return null;
    }

    @Override
    public boolean deleteCity(Long id) {
        return false;
    }

    @Override
    public boolean indexListOfCities(List<IndexUnitCity> indexUnitCityList) {
        indexerCityService.indexListOfCities(indexUnitCityList);
        return true;
    }
}
