package com.ftn.master.geoandtimesearchmapapi.config.scanner;

import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.IndexUnitCity;
import com.ftn.master.geoandtimesearchmapapi.service.CityService;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//@Component
public class ReadCsvCities {

    private final CityService cityService;

    public ReadCsvCities(CityService cityService) {
        this.cityService = cityService;
    }


//    @PostConstruct
    public void readCsv() throws Exception{
        URL resource = getClass().getClassLoader().getResource("worldcities.csv");
        Scanner sc = new Scanner(new File(resource.toURI()));
        sc.useDelimiter("\n");
        List<IndexUnitCity> indexUnitCityList = new ArrayList<>();
        sc.next();
        while (sc.hasNext()){
            String[] city = sc.next().split(",");
            IndexUnitCity indexUnitCity = new IndexUnitCity();
            indexUnitCity.setId(city[10].replace("\"",""));
            indexUnitCity.setName(city[0].replace("\"",""));
            indexUnitCity.setNameAscii(city[1].replace("\"",""));
            indexUnitCity.setGeoPoint(new GeoPoint(Double.parseDouble(city[2].replace("\"","")),Double.parseDouble(city[3].replace("\"",""))));
            indexUnitCity.setCountry(city[4].replace("\"",""));
            indexUnitCity.setIso3(city[6].replace("\"",""));
            indexUnitCity.setAdminName(city[7].replace("\"",""));
            indexUnitCityList.add(indexUnitCity);
        }

        cityService.indexListOfCities(indexUnitCityList);

        sc.close();
    }

}
