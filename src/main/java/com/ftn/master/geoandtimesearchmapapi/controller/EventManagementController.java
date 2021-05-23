package com.ftn.master.geoandtimesearchmapapi.controller;

import com.ftn.master.geoandtimesearchmapapi.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/event")
public class EventManagementController {

    private final EventService eventService;

    public EventManagementController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("approved")
    @PreAuthorize(value = "hasAuthority('HEAD_ADMIN') or hasRole('HEAD_ADMIN')")
    public ResponseEntity<?> getAllApproved(){
        return ResponseEntity.ok(eventService.getAllApproved());
    }

    @GetMapping("requested")
    @PreAuthorize(value = "hasAuthority('HEAD_ADMIN') or hasRole('HEAD_ADMIN')")
    public ResponseEntity<?> getAllRequestedEvents(){
        return ResponseEntity.ok(eventService.getAllRequestedEvents());
    }

}
