package com.ftn.master.geoandtimesearchmapapi.controller;

import com.ftn.master.geoandtimesearchmapapi.dto.AddEventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.EventDTO;
import com.ftn.master.geoandtimesearchmapapi.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping
    public ResponseEntity<?> getAllEvents(){
        return ResponseEntity.ok(eventService.findAllEvents());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findOneEvent(@PathVariable Long id){
        return ResponseEntity.ok(eventService.findOneEvent(id));
    }

    @PostMapping
    public ResponseEntity<?> saveEvent(@RequestBody AddEventDTO addEventDTO){
        return ResponseEntity.ok(eventService.saveEvent(addEventDTO));
    }
}