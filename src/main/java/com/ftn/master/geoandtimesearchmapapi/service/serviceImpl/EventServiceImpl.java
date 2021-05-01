package com.ftn.master.geoandtimesearchmapapi.service.serviceImpl;

import com.ftn.master.geoandtimesearchmapapi.domain.Event;
import com.ftn.master.geoandtimesearchmapapi.dto.AddEventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.EventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.EventListDTO;
import com.ftn.master.geoandtimesearchmapapi.helper.EventMapperHelper;
import com.ftn.master.geoandtimesearchmapapi.lucene.indexing.IndexerEventService;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.IndexUnitEvent;
import com.ftn.master.geoandtimesearchmapapi.repository.EventRepository;
import com.ftn.master.geoandtimesearchmapapi.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventServiceImpl implements EventService {

    private final IndexerEventService indexerEventService;

    private final EventRepository eventRepository;

    public EventServiceImpl(IndexerEventService indexerEventService, EventRepository eventRepository) {
        this.indexerEventService = indexerEventService;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventListDTO findAllEvents() {
        List<Event> events = eventRepository.findAll();
        EventListDTO eventListDTO = new EventListDTO();
        for(Event event: events) {
            eventListDTO.getEvents().add(EventMapperHelper.eventDTOFromEvent(event));
        }
        return eventListDTO;
    }

    @Override
    public EventDTO findOneEvent(Long id) {
        Event event = eventRepository.getOne(id);
        return EventMapperHelper.eventDTOFromEvent(event);
    }

    @Override
    public EventListDTO getAllApproved() {
        List<Event> events = eventRepository.getAllApproved();
        EventListDTO eventListDTO = new EventListDTO();
        for(Event event : events){
            eventListDTO.getEvents().add(EventMapperHelper.eventDTOFromEvent(event));
        }
        return eventListDTO;
    }

    @Override
    public EventListDTO getAllRequestedEvents() {
        List<Event> events = eventRepository.getAllRequestedEvents();
        EventListDTO eventListDTO = new EventListDTO();
        for(Event event: events) {
            eventListDTO.getEvents().add(EventMapperHelper.eventDTOFromEvent(event));
        }
        return eventListDTO;
    }

    @Override
    public EventDTO approveEvent(EventDTO eventDTO) {
        Event event = eventRepository.getOne(eventDTO.getId());
        event.setApproved(true);
        eventRepository.save(event);
        indexerEventService.updateEvent(EventMapperHelper.indexUnitEventFromDomainMapper(event));
        return EventMapperHelper.eventDTOFromEvent(event);
    }

    @Override
    public EventDTO saveEvent(AddEventDTO addEventDTO) {
        Event event = EventMapperHelper.createEventForAddFromDTO(addEventDTO);
        event = eventRepository.save(event);
        IndexUnitEvent indexUnitEvent = EventMapperHelper.indexUnitEventFromDomainMapper(event);

        indexerEventService.addEvent(indexUnitEvent);

        return EventMapperHelper.eventDTOFromEvent(event);
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDTO)
    {
        Event event = eventRepository.getOne(eventDTO.getId());
        event.setName(eventDTO.getName() !=null ? eventDTO.getName() : event.getName());
        event.setDescription(eventDTO.getDescription() !=null ? eventDTO.getDescription() : event.getDescription());
        event.setLat(eventDTO.getLat() != 0 ? eventDTO.getLat() : event.getLat());
        event.setLon(eventDTO.getLon() != 0 ? eventDTO.getLon() : event.getLon());
        event.setCategory(eventDTO.getCategory() !=null ? eventDTO.getCategory() : event.getCategory());
        event.setEventDate(eventDTO.getEventDate() != null ? eventDTO.getEventDate() : event.getEventDate());

        event = eventRepository.save(event);
        indexerEventService.updateEvent(EventMapperHelper.indexUnitEventFromDomainMapper(event));

        return EventMapperHelper.eventDTOFromEvent(event);
    }

    @Override
    public boolean deleteEvent(Long id) {
        return false;
    }
}
