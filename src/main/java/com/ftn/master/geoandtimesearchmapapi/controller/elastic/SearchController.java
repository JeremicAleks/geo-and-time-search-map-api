package com.ftn.master.geoandtimesearchmapapi.controller.elastic;

import com.ftn.master.geoandtimesearchmapapi.lucene.model.SimpleQuery;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.GeoAndTimeQuery;
import com.ftn.master.geoandtimesearchmapapi.service.elastic.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/search")
public class SearchController {

		private final SearchService searchService;


	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}


	@PostMapping
	public ResponseEntity<?> searchCityByName(@RequestBody  SimpleQuery simpleQuery){
		return ResponseEntity.ok(searchService.getCityByName(simpleQuery.getValue()));
	}

	@PostMapping("/or")
	public ResponseEntity<?> searchByOr(@RequestBody SimpleQuery simpleQuery) {
		return ResponseEntity.ok(searchService.getCityByNameOrAdminName(simpleQuery.getValue()));
	}

	@PostMapping("/geoPoint")
	public ResponseEntity<?> searchGeoPoint(@RequestBody GeoAndTimeQuery geoAndTimeQuery) throws Exception{
		return ResponseEntity.ok(searchService.geoAndTimeSearch(geoAndTimeQuery));
	}

	
}
