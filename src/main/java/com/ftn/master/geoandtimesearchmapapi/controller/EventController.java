package com.ftn.master.geoandtimesearchmapapi.controller;

import com.ftn.master.geoandtimesearchmapapi.dto.AddEventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.EventDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.PageableRequestDTO;
import com.ftn.master.geoandtimesearchmapapi.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*")
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

//    @GetMapping("approved")
//    public ResponseEntity<?> getAllApproved(){
//        return ResponseEntity.ok(eventService.getAllApproved());
//    }
//
//    @GetMapping("requested")
//    public ResponseEntity<?> getAllRequestedEvents(){
//        return ResponseEntity.ok(eventService.getAllRequestedEvents());
//    }

    @PostMapping
    public ResponseEntity<?> saveEvent(@RequestBody AddEventDTO addEventDTO){
        return ResponseEntity.ok(eventService.saveEvent(addEventDTO));
    }

    @PostMapping("approve")
    public ResponseEntity<?> approveEvent(@RequestBody EventDTO eventDTO){
        return ResponseEntity.ok(eventService.approveEvent(eventDTO));
    }

    @PutMapping()
    public ResponseEntity<?> updateEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.updateEvent(eventDTO));
    }

    @PostMapping("upload/{id}")
    public ResponseEntity<?> uploadImage(@PathVariable("id") Long id, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        return ResponseEntity.ok(eventService.uploadImage(id,imageFile));
    }


    @PostMapping("pageable")
    public ResponseEntity<?> pageableGetEvents(@RequestBody PageableRequestDTO pageableRequestDTO){
        return ResponseEntity.ok(eventService.pageableGetEvent(pageableRequestDTO));
    }



}
