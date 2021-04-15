package com.ftn.master.geoandtimesearchmapapi.lucene.model;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Date;

public class ResultDataEventDTO {
    private String name;
    private GeoPoint geoPoint;
    private Date eventDate;

    public ResultDataEventDTO() {
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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
