package com.ftn.master.geoandtimesearchmapapi.service.serviceImpl;

import com.ftn.master.geoandtimesearchmapapi.domain.Event;
import com.ftn.master.geoandtimesearchmapapi.dto.EventDTO;
import com.ftn.master.geoandtimesearchmapapi.lucene.indexing.IndexerEventService;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.IndexUnitEvent;
import com.ftn.master.geoandtimesearchmapapi.service.EventService;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final IndexerEventService indexerEventService;

    public EventServiceImpl(IndexerEventService indexerEventService) {
        this.indexerEventService = indexerEventService;
    }


    @Override
    public List<Event> findAllEvents() {
        return null;
    }

    @Override
    public Event findOneEvent(Long id) {
        return null;
    }

    @Override
    public Event saveEvent(EventDTO eventDTO) {
        IndexUnitEvent indexUnitEvent = new IndexUnitEvent();
        indexUnitEvent.setName(eventDTO.getName());
        indexUnitEvent.setDescription(eventDTO.getDescription());
        indexUnitEvent.setEventDate(eventDTO.getEventDate());
        indexUnitEvent.setGeoPoint(new GeoPoint(eventDTO.getLat(),eventDTO.getLng()));
        indexUnitEvent.setId(eventDTO.getId().toString());

        indexerEventService.addEvent(indexUnitEvent);

        return null;
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public boolean deleteEvent(Long id) {
        return false;
    }
}
