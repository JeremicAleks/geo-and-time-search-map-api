package com.ftn.master.geoandtimesearchmapapi.dto;

import java.util.ArrayList;
import java.util.List;

public class UserListDTO {
    private List<UserDTO> users;

    public UserListDTO() {
        this.users = new ArrayList<>();
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
