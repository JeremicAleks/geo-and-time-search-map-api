package com.ftn.master.geoandtimesearchmapapi.service;

import com.ftn.master.geoandtimesearchmapapi.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EventService {

    EventListDTO findAllEvents();
    EventDTO findOneEvent(Long id);
    EventListDTO getAllApproved();
    EventListDTO getAllRequestedEvents();
    EventDTO approveEvent(EventDTO eventDTO);
    EventDTO saveEvent(AddEventDTO addEventDTO);
    EventDTO updateEvent(EventDTO eventDTO);
    boolean deleteEvent(Long id);
    boolean uploadImage(Long id, MultipartFile imageFile) throws IOException;
    PageableResponseEventDTO pageableGetEvent(PageableRequestDTO pageableRequestDTO);
}
