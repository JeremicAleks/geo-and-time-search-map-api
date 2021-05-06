package com.ftn.master.geoandtimesearchmapapi.service;

import com.ftn.master.geoandtimesearchmapapi.dto.RegistrationDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.UserDTO;

public interface UserService {

    UserDTO findOneUserById(Long id);
    UserDTO findUserByUsername(String username);
    UserDTO userRegistration(RegistrationDTO registrationDTO);


}
