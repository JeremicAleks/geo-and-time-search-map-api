package com.ftn.master.geoandtimesearchmapapi.dto;

import java.util.ArrayList;
import java.util.List;

public class EventListDTO {
    private List<EventDTO> events;

    public EventListDTO() {
        this.events = new ArrayList<>();
    }

    public List<EventDTO> getEvents() {
        return events;
    }

    public void setEvents(List<EventDTO> events) {
        this.events = events;
    }
}
