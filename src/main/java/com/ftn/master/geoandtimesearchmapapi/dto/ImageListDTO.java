package com.ftn.master.geoandtimesearchmapapi.dto;

import java.util.ArrayList;
import java.util.List;

public class ImageListDTO {
    private List<ImageDTO> images;

    public ImageListDTO() {
        this.images = new ArrayList<>();
    }


    public List<ImageDTO> getImages() {
        return images;
    }

    public void setImages(List<ImageDTO> images) {
        this.images = images;
    }
}
