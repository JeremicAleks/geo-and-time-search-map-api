package com.ftn.master.geoandtimesearchmapapi.dto;

public class PageableRequestDTO {

    private int page;
    private int size;
    private boolean flagFilter;


    public PageableRequestDTO() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFlagFilter() {
        return flagFilter;
    }

    public void setFlagFilter(boolean flagFilter) {
        this.flagFilter = flagFilter;
    }
}
