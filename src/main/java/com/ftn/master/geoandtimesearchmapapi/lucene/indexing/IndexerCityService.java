package com.ftn.master.geoandtimesearchmapapi.lucene.indexing;

import com.ftn.master.geoandtimesearchmapapi.lucene.model.IndexUnitCity;

public interface IndexerCityService {

    boolean addCity(IndexUnitCity indexUnitCity);
    boolean deleteCity(IndexUnitCity indexUnitCity);
    boolean updateCity(IndexUnitCity indexUnitCity);




}
