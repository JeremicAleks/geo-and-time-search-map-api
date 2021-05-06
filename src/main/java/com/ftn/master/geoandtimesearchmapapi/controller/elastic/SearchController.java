package com.ftn.master.geoandtimesearchmapapi.controller.elastic;

import com.ftn.master.geoandtimesearchmapapi.lucene.model.SimpleQuery;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.GeoAndTimeQuery;
import com.ftn.master.geoandtimesearchmapapi.service.elastic.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(value = "*")
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

	//TODO: change List to one city
	@PostMapping("/or")
	public ResponseEntity<?> searchByOr(@RequestBody SimpleQuery simpleQuery) {
		return ResponseEntity.ok(searchService.getCityByNameOrNameAscii(simpleQuery.getValue()).size()>0 ? searchService.getCityByNameOrNameAscii(simpleQuery.getValue()).get(0) : -1);
	}

	@PostMapping("/city")
	public ResponseEntity<?> searchCity(@RequestBody SimpleQuery simpleQuery){
		return ResponseEntity.ok(searchService.getCityByNameOrAdminNameOrNameAscii(simpleQuery.getValue()).size() > 0 ? searchService.getCityByNameOrAdminNameOrNameAscii(simpleQuery.getValue()).get(0) : -1 );
	}


	@PostMapping("/geoPoint")
	public ResponseEntity<?> searchGeoPoint(@RequestBody GeoAndTimeQuery geoAndTimeQuery) throws Exception{
		return ResponseEntity.ok(searchService.geoAndTimeSearch(geoAndTimeQuery));
	}


	@GetMapping("cities/{name}")
	public ResponseEntity<?> findAllCitiesStartWith(@PathVariable("name") String name){
		return ResponseEntity.ok(searchService.getCitiesStartWith(name));
	}
	
}
