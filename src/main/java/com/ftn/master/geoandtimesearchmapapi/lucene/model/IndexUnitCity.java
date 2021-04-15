package com.ftn.master.geoandtimesearchmapapi.lucene.model;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import javax.persistence.Id;

@Document(indexName = "city",shards = 1,replicas = 0)
public class IndexUnitCity {
    @Id
    private  String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String nameAscii;

    @Field(type = FieldType.Text)
    private String country;

    @Field(type = FieldType.Text)
    private String iso3;

    @Field(type = FieldType.Text)
    private String adminName;

    @GeoPointField
    private GeoPoint geoPoint;

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

    public String getNameAscii() {
        return nameAscii;
    }

    public void setNameAscii(String nameAscii) {
        this.nameAscii = nameAscii;
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

    public GeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.geoPoint = geoPoint;
    }
}
