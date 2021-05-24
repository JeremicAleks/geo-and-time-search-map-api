package com.ftn.master.geoandtimesearchmapapi.service.elastic;

import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.GeoAndTimeQuery;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.ResultDataCity;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.ResultDataDTO;

import java.util.List;


public interface SearchService {
    List<ResultDataCity> getCityByName(String name);

    List<ResultDataCity> getCityByNameOrAdminName(String name);

    ResultDataDTO geoAndTimeSearch(GeoAndTimeQuery geoAndTimeQuery) throws Exception;

    List<ResultDataCity> getCityByNameOrNameAscii(String name);

    ResultDataCity getCityByNameOrAdminNameOrNameAscii(String name);

    ResultDataCity getCityByNameAndCountry(String name,String country);


    List<ResultDataCity> getCitiesStartWith(String name);
}
