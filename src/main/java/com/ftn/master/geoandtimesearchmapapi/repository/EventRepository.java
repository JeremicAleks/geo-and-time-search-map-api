package com.ftn.master.geoandtimesearchmapapi.repository;

import com.ftn.master.geoandtimesearchmapapi.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
