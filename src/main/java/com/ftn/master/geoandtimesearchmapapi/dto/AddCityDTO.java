package com.ftn.master.geoandtimesearchmapapi.dto;

public class AddCityDTO {
    private String name;
    private String nameAscii;
    private double lat;
    private double lng;
    private String country;
    private String iso3;
    private String adminName;

    public AddCityDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAscii() {
        return nameAscii;
    }

    public void setNameAscii(String nameAscii) {
        this.nameAscii = nameAscii;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
