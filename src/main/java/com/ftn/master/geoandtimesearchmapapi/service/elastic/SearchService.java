package com.ftn.master.geoandtimesearchmapapi.service.elastic;

import com.ftn.master.geoandtimesearchmapapi.lucene.model.GeoAndTimeQuery;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.ResultDataCity;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.ResultDataDTO;

import java.util.List;


public interface SearchService {
    List<ResultDataCity> getCityByName(String name);

    List<ResultDataCity> getCityByNameOrAdminName(String name);

    ResultDataDTO geoAndTimeSearch(GeoAndTimeQuery geoAndTimeQuery) throws Exception;

    List<ResultDataCity> getCityByNameOrNameAscii(String name);

    List<ResultDataCity> getCityByNameOrAdminNameOrNameAscii(String name);
}
