package com.ftn.master.geoandtimesearchmapapi.lucene.indexing;

import com.ftn.master.geoandtimesearchmapapi.lucene.model.IndexUnitCity;

import java.util.List;

public interface IndexerCityService {

    boolean addCity(IndexUnitCity indexUnitCity);
    boolean indexListOfCities(List<IndexUnitCity> indexUnitCityList);
    boolean deleteCity(IndexUnitCity indexUnitCity);
    boolean updateCity(IndexUnitCity indexUnitCity);




}
