package com.ftn.master.geoandtimesearchmapapi.service;

import com.ftn.master.geoandtimesearchmapapi.dto.*;

public interface UserService {

    UserDTO findOneUserById(Long id);
    UserDTO findUserByUsername(String username);
    UserDTO userRegistration(RegistrationDTO registrationDTO);
    UserListDTO getAllEnabledUsers();
    UserListDTO getAllDisabledUsers();
    UserDTO enableUser(UserDTO userDTO);
    UserDTO disableUser(UserDTO userDTO);
    PageableResponseUserDTO pageableGetUsers(PageableRequestDTO pageableRequestDTO);
}
