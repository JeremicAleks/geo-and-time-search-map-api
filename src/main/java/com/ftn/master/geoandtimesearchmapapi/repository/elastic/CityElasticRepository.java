package com.ftn.master.geoandtimesearchmapapi.repository.elastic;

import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.IndexUnitCity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CityElasticRepository extends ElasticsearchRepository<IndexUnitCity,String> {
    List<IndexUnitCity> findByName(String name);
    List<IndexUnitCity> findByNameOrAdminName(String name,String adminName);
    List<IndexUnitCity> findByNameOrNameAscii(String name,String nameAscii);
    List<IndexUnitCity> findByNameOrAdminNameOrNameAscii(String name,String adminName,String nameAscii);
    List<IndexUnitCity> findByNameAndCountry(String name,String country);
    List<IndexUnitCity> findByNameLikeOrAdminNameLikeOrNameAsciiLike(String name,String adminName,String nameAscii);
}
