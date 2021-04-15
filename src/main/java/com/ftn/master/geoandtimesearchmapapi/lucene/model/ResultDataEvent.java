package com.ftn.master.geoandtimesearchmapapi.lucene.model;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Date;

public class ResultDataEvent {
    private String id;
    private String name;
    private String description;
    private Date eventDate;
    private GeoPoint geoPoint;

    public ResultDataEvent() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }
}
