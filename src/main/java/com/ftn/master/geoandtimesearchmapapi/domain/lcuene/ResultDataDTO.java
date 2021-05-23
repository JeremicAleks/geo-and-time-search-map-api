package com.ftn.master.geoandtimesearchmapapi.domain.lcuene;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

public class ResultDataDTO {
    private String name;
    private GeoPoint geoPoint;
    private List<ResultDataEvent> resultDataEvents;

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

    public List<ResultDataEvent> getResultDataEvents() {
        return resultDataEvents;
    }

    public void setResultDataEvents(List<ResultDataEvent> resultDataEvents) {
        this.resultDataEvents = resultDataEvents;
    }
}
