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
    EventDTO saveEvent(AddEventDTO addEventDTO, String name);
    EventDTO updateEvent(EventDTO eventDTO);
    boolean deleteEvent(Long id);
    boolean uploadImage(Long id, MultipartFile imageFile) throws IOException;
    PageableResponseEventDTO pageableGetEvent(PageableRequestDTO pageableRequestDTO);
    PageableResponseEventDTO pageableGetEventUserUsername(PageableRequestDTO pageableRequestDTO,String username);

    ImageListDTO getAllImagesFromEvent(Long id);

    boolean deleteImage(Long id);
}
