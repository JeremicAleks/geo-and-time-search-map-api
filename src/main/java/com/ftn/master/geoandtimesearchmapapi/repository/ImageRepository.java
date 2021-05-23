package com.ftn.master.geoandtimesearchmapapi.repository;

import com.ftn.master.geoandtimesearchmapapi.domain.Event;
import com.ftn.master.geoandtimesearchmapapi.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image,Long> {

    List<Image> findByEvent(Event event);
}
