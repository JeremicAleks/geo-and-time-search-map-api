package com.ftn.master.geoandtimesearchmapapi.service;

import com.ftn.master.geoandtimesearchmapapi.domain.Event;
import com.ftn.master.geoandtimesearchmapapi.dto.EventDTO;

import java.util.List;

public interface EventService {

    List<Event> findAllEvents();
    Event findOneEvent(Long id);
    Event saveEvent(EventDTO eventDTO);
    Event updateEvent(Event event);
    boolean deleteEvent(Long id);


}
