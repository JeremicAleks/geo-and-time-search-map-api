package com.ftn.master.geoandtimesearchmapapi.repository;

import com.ftn.master.geoandtimesearchmapapi.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

    @Query("select u from User u where u.enabled = true ")
    List<User> getAllEnabledUsers();

    @Query("select u from User u where u.enabled = false ")
    List<User> getAllDisabledUsers();

    Page<User> findByEnabled(boolean enabled, Pageable pageable);

}
