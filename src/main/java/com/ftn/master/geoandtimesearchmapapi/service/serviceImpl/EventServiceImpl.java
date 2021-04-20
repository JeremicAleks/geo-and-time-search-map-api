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
    public EventDTO saveEvent(AddEventDTO addEventDTO) {
        Event event = EventMapperHelper.createEventForAddFromDTO(addEventDTO);
        event = eventRepository.save(event);
        IndexUnitEvent indexUnitEvent = EventMapperHelper.indexUnitEventFromDomainMapper(event);

        indexerEventService.addEvent(indexUnitEvent);

        return EventMapperHelper.eventDTOFromEvent(event);
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
