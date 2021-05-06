package com.ftn.master.geoandtimesearchmapapi.helper;

import com.ftn.master.geoandtimesearchmapapi.domain.Event;
import com.ftn.master.geoandtimesearchmapapi.domain.Image;
import com.ftn.master.geoandtimesearchmapapi.dto.AddEventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.EventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.ImageDTO;
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
        event.setCategory(addEventDTO.getCategory());
        event.setAddress(addEventDTO.getAddress());
        event.setWebSite(addEventDTO.getWebSite());
        event.setPhone(addEventDTO.getPhone());
        event.setCity(addEventDTO.getCity());
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
        eventDTO.setCategory(event.getCategory());
        eventDTO.setAddress(event.getAddress());
        eventDTO.setWebSite(event.getWebSite());
        eventDTO.setPhone(event.getPhone());
        eventDTO.setCity(event.getCity());
        if(event.getImages()!=null && event.getImages().size()>0) {
            for (Image image : event.getImages()) {
                ImageDTO imageDTO = new ImageDTO();
                imageDTO.setId(image.getId());
                imageDTO.setName(image.getName());
                imageDTO.setType(image.getType());
                imageDTO.setPicByte(ImageCompressHelper.decompressZLib(image.getPicByte()));
                eventDTO.getImages().add(imageDTO);
            }
        }
        return eventDTO;
    }

    public static IndexUnitEvent indexUnitEventFromDomainMapper(Event event){
        IndexUnitEvent indexUnitEvent = new IndexUnitEvent();
        indexUnitEvent.setId(event.getId());
        indexUnitEvent.setName(event.getName());
        indexUnitEvent.setDescription(event.getDescription());
        indexUnitEvent.setGeoPoint(new GeoPoint(event.getLat(),event.getLon()));
        indexUnitEvent.setEventDate(event.getEventDate());
        indexUnitEvent.setCategory(event.getCategory());
        indexUnitEvent.setApproved(event.isApproved());
        indexUnitEvent.setAddress(event.getAddress());
        indexUnitEvent.setWebSite(event.getWebSite());
        indexUnitEvent.setPhone(event.getPhone());
        indexUnitEvent.setCity(event.getCity());
        return indexUnitEvent;
    }



}
