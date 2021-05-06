package com.ftn.master.geoandtimesearchmapapi.controller;

import com.ftn.master.geoandtimesearchmapapi.dto.RegistrationDTO;
import com.ftn.master.geoandtimesearchmapapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> userRegistration(@RequestBody RegistrationDTO registrationDTO){
        return ResponseEntity.ok(userService.userRegistration(registrationDTO));
    }

}
