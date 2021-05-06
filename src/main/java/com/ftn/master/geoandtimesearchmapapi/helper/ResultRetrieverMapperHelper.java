package com.ftn.master.geoandtimesearchmapapi.helper;

import com.ftn.master.geoandtimesearchmapapi.lucene.model.IndexUnitCity;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.ResultDataCity;
import org.springframework.stereotype.Component;

@Component
public final class ResultRetrieverMapperHelper {

    public static ResultDataCity resultDataCityFromIndex(IndexUnitCity indexUnitCity){
        ResultDataCity resultDataCity = new ResultDataCity();
        resultDataCity.setAdminName(indexUnitCity.getAdminName());
        resultDataCity.setCountry(indexUnitCity.getCountry());
        resultDataCity.setGeoPoint(indexUnitCity.getGeoPoint());
        resultDataCity.setIso3(indexUnitCity.getIso3());
        resultDataCity.setName(indexUnitCity.getName());
        resultDataCity.setNameAscii(indexUnitCity.getNameAscii());
        resultDataCity.setId(indexUnitCity.getId());

        return resultDataCity;
    }

}
