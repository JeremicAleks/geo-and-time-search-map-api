package com.ftn.master.geoandtimesearchmapapi.dto;

public class PageableResponseEventDTO {
    private long totalElements;
    private int totalPages;
    private EventListDTO eventListDTO;

    public PageableResponseEventDTO() {
        this.eventListDTO = new EventListDTO();
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

    public EventListDTO getEventListDTO() {
        return eventListDTO;
    }

    public void setEventListDTO(EventListDTO eventListDTO) {
        this.eventListDTO = eventListDTO;
    }
}
