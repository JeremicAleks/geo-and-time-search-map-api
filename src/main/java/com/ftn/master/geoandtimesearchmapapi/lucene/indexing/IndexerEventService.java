package com.ftn.master.geoandtimesearchmapapi.lucene.indexing;

import com.ftn.master.geoandtimesearchmapapi.lucene.model.IndexUnitEvent;

public interface IndexerEventService {
    boolean addEvent(IndexUnitEvent indexUnitEvent);
    boolean updateEvent(IndexUnitEvent indexUnitEvent);
    boolean deleteEvent(IndexUnitEvent indexUnitEvent);
}
