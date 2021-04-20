package com.ftn.master.geoandtimesearchmapapi.service;

import com.ftn.master.geoandtimesearchmapapi.domain.Event;
import com.ftn.master.geoandtimesearchmapapi.dto.AddEventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.EventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.EventListDTO;

import java.util.List;

public interface EventService {

    EventListDTO findAllEvents();
    EventDTO findOneEvent(Long id);
    EventDTO saveEvent(AddEventDTO addEventDTO);
    Event updateEvent(Event event);
    boolean deleteEvent(Long id);


}
