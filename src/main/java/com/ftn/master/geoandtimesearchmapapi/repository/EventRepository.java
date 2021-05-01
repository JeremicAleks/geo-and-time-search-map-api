package com.ftn.master.geoandtimesearchmapapi.repository;

import com.ftn.master.geoandtimesearchmapapi.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {

    @Query("select e from Event e where e.approved = true ")
    List<Event> getAllApproved();

    @Query("select e from Event e where e.approved= false")
    List<Event> getAllRequestedEvents();
}
