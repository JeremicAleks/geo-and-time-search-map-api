package com.ftn.master.geoandtimesearchmapapi.lucene.model;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

public class ResultDataDTO {
    private String name;
    private GeoPoint geoPoint;
    private List<ResultDataEventDTO> resultDataEvents;

    public ResultDataDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }

    public List<ResultDataEventDTO> getResultDataEvents() {
        return resultDataEvents;
    }

    public void setResultDataEvents(List<ResultDataEventDTO> resultDataEvents) {
        this.resultDataEvents = resultDataEvents;
    }
}
