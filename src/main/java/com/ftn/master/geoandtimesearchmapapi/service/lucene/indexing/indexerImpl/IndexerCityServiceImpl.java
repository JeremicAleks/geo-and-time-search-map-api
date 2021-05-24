package com.ftn.master.geoandtimesearchmapapi.service.lucene.indexing.indexerImpl;

import com.ftn.master.geoandtimesearchmapapi.service.lucene.indexing.IndexerCityService;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.IndexUnitCity;
import com.ftn.master.geoandtimesearchmapapi.repository.elastic.CityElasticRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexerCityServiceImpl implements IndexerCityService {

    private final CityElasticRepository cityElasticRepository;

    public IndexerCityServiceImpl(CityElasticRepository cityElasticRepository) {
        this.cityElasticRepository = cityElasticRepository;
    }

    @Override
    public boolean addCity(IndexUnitCity indexUnitCity) {
        cityElasticRepository.save(indexUnitCity);
        return true;
    }

    @Override
    public boolean indexListOfCities(List<IndexUnitCity> indexUnitCityList) {
        cityElasticRepository.saveAll(indexUnitCityList);
        return true;
    }


    @Override
    public boolean deleteCity(IndexUnitCity indexUnitCity) {
        cityElasticRepository.delete(indexUnitCity);
        return true;
    }

    @Override
    public boolean updateCity(IndexUnitCity indexUnitCity) {
        cityElasticRepository.save(indexUnitCity);
        return true;
    }
}
