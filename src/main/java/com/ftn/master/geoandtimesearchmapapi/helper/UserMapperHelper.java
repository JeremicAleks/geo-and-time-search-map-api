package com.ftn.master.geoandtimesearchmapapi.helper;

import com.ftn.master.geoandtimesearchmapapi.domain.User;
import com.ftn.master.geoandtimesearchmapapi.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public final class UserMapperHelper {

    public static UserDTO userDTOFromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

}
