package com.ftn.master.geoandtimesearchmapapi.helper;

import com.ftn.master.geoandtimesearchmapapi.domain.Event;
import com.ftn.master.geoandtimesearchmapapi.dto.AddEventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.EventDTO;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.IndexUnitEvent;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Component;

@Component
public final class EventMapperHelper {

    public static Event createEventForAddFromDTO(AddEventDTO addEventDTO){
        Event event = new Event();
        event.setName(addEventDTO.getName());
        event.setDescription(addEventDTO.getDescription());
        event.setLat(addEventDTO.getLat());
        event.setLon(addEventDTO.getLon());
        event.setApproved(false); //TODO: Videti da li treba da ostane false
        event.setEventDate(addEventDTO.getEventDate());
        return event;
    }

    public static EventDTO eventDTOFromEvent(Event event){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setName(event.getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setLat(event.getLat());
        eventDTO.setLon(event.getLon());
        eventDTO.setId(event.getId());
        eventDTO.setEventDate(event.getEventDate());
        return eventDTO;
    }

    public static IndexUnitEvent indexUnitEventFromDomainMapper(Event event){
        IndexUnitEvent indexUnitEvent = new IndexUnitEvent();
        indexUnitEvent.setId(event.getId().toString());
        indexUnitEvent.setName(event.getName());
        indexUnitEvent.setDescription(event.getDescription());
        indexUnitEvent.setGeoPoint(new GeoPoint(event.getLat(),event.getLon()));
        indexUnitEvent.setEventDate(event.getEventDate());
        return indexUnitEvent;
    }



}
