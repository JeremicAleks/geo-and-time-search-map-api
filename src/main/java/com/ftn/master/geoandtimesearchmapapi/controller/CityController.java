package com.ftn.master.geoandtimesearchmapapi.controller;

import com.ftn.master.geoandtimesearchmapapi.dto.AddCityDTO;
import com.ftn.master.geoandtimesearchmapapi.dto.CityDTO;
import com.ftn.master.geoandtimesearchmapapi.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<?> getOneCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(cityService.findCityById(cityId));
    }

    @PostMapping
    public ResponseEntity<?> saveCity(@RequestBody CityDTO addCityDTO){
        return ResponseEntity.ok(cityService.saveCity(addCityDTO));
    }




}
