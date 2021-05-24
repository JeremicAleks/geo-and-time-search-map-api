package com.ftn.master.geoandtimesearchmapapi.repository.elastic;

import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.IndexUnitEvent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EventElasticRepository extends ElasticsearchRepository<IndexUnitEvent,String> {
}
