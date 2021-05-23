package com.ftn.master.geoandtimesearchmapapi.service.lucene.indexing;

import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.IndexUnitEvent;

public interface IndexerEventService {
    boolean addEvent(IndexUnitEvent indexUnitEvent);
    boolean updateEvent(IndexUnitEvent indexUnitEvent);
    boolean deleteEvent(IndexUnitEvent indexUnitEvent);
}
