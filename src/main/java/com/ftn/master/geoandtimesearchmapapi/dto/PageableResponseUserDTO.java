package com.ftn.master.geoandtimesearchmapapi.dto;

public class PageableResponseUserDTO {
    private long totalElements;
    private int totalPages;
    private UserListDTO userListDTO;

    public PageableResponseUserDTO() {
        this.userListDTO = new UserListDTO();
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public UserListDTO getUserListDTO() {
        return userListDTO;
    }

    public void setUserListDTO(UserListDTO userListDTO) {
        this.userListDTO = userListDTO;
    }
}
