package com.ftn.master.geoandtimesearchmapapi.controller;

import com.ftn.master.geoandtimesearchmapapi.dto.PageableRequestDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.UserDTO;
import com.ftn.master.geoandtimesearchmapapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("management/api/user")
public class UserManagementController {

    private final UserService userService;

    public UserManagementController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("enabled")
    @PreAuthorize(value = "hasAuthority('HEAD_ADMIN') or hasRole('HEAD_ADMIN')")
    public ResponseEntity<?> getAllEnabled(){
        return ResponseEntity.ok(userService.getAllEnabledUsers());
    }

    @GetMapping("disabled")
    @PreAuthorize(value = "hasAuthority('HEAD_ADMIN') or hasRole('HEAD_ADMIN')")
    public ResponseEntity<?> getAllDisabled() {
        return ResponseEntity.ok(userService.getAllDisabledUsers());
    }

    @PostMapping("enableUser")
    @PreAuthorize(value = "hasAuthority('HEAD_ADMIN') or hasRole('HEAD_ADMIN')")
    public ResponseEntity<?> enableUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.enableUser(userDTO));
    }

    @PostMapping("disableUser")
    @PreAuthorize(value = "hasAuthority('HEAD_ADMIN') or hasRole('HEAD_ADMIN')")
    public ResponseEntity<?> disableUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.disableUser(userDTO));
    }

    @PostMapping("pageable")
    @PreAuthorize(value = "hasAuthority('HEAD_ADMIN') or hasRole('HEAD_ADMIN')")
    public ResponseEntity<?> pageableGetUsers(@RequestBody PageableRequestDTO pageableRequestDTO){
        return ResponseEntity.ok(userService.pageableGetUsers(pageableRequestDTO));
    }


}
