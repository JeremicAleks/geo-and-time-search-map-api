package com.ftn.master.geoandtimesearchmapapi.lucene.indexing.indexerImpl;

import com.ftn.master.geoandtimesearchmapapi.lucene.indexing.IndexerEventService;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.IndexUnitEvent;
import com.ftn.master.geoandtimesearchmapapi.repository.elastic.EventElasticRepository;
import org.springframework.stereotype.Service;

@Service
public class IndexerEventServiceImpl implements IndexerEventService {
    private final EventElasticRepository eventElasticRepository;

    public IndexerEventServiceImpl(EventElasticRepository eventElasticRepository) {
        this.eventElasticRepository = eventElasticRepository;
    }


    @Override
    public boolean addEvent(IndexUnitEvent indexUnitEvent) {
        eventElasticRepository.save(indexUnitEvent);
        return true;
    }

    @Override
    public boolean updateEvent(IndexUnitEvent indexUnitEvent) {
        eventElasticRepository.save(indexUnitEvent);
        return true;
    }

    @Override
    public boolean deleteEvent(IndexUnitEvent indexUnitEvent) {
        eventElasticRepository.delete(indexUnitEvent);
        return false;
    }
}
