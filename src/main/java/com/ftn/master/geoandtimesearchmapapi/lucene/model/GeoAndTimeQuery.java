package com.ftn.master.geoandtimesearchmapapi.lucene.model;

import java.util.Date;

public class GeoAndTimeQuery {
    private String cityName;
    private Date fromDate;
    private Date toDate;

    public GeoAndTimeQuery() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
