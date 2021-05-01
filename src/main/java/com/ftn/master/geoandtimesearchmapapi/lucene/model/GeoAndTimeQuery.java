package com.ftn.master.geoandtimesearchmapapi.lucene.model;

import java.util.Date;

public class GeoAndTimeQuery {
    private String cityName;
    private Date startDate;
    private Date endDate;

    public GeoAndTimeQuery() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
