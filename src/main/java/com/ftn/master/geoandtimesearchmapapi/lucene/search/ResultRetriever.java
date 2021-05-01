package com.ftn.master.geoandtimesearchmapapi.lucene.search;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.IndexUnitCity;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.ResultDataCity;
import com.ftn.master.geoandtimesearchmapapi.lucene.model.ResultDataEvent;
import com.ftn.master.geoandtimesearchmapapi.repository.elastic.CityElasticRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultRetriever {

	private final CityElasticRepository cityElasticRepository;
	private final RestHighLevelClient restHighLevelClient;


	public ResultRetriever(CityElasticRepository cityElasticRepository, RestHighLevelClient restHighLevelClient){
		this.cityElasticRepository = cityElasticRepository;
		this.restHighLevelClient = restHighLevelClient;
	}


	public List<ResultDataCity> getCityByName(String name){
		List<IndexUnitCity> listOfCity = cityElasticRepository.findByName(name);
		List<ResultDataCity> resultDataCityList = new ArrayList<>();
		for(IndexUnitCity indexUnitCity: listOfCity) {
			ResultDataCity resultDataCity = new ResultDataCity();
			resultDataCity.setAdminName(indexUnitCity.getAdminName());
			resultDataCity.setCountry(indexUnitCity.getCountry());
			resultDataCity.setGeoPoint(indexUnitCity.getGeoPoint());
			resultDataCity.setIso3(indexUnitCity.getIso3());
			resultDataCity.setName(indexUnitCity.getName());
			resultDataCity.setNameAscii(indexUnitCity.getNameAscii());
			resultDataCity.setId(indexUnitCity.getId());
			resultDataCityList.add(resultDataCity);
		}

		return resultDataCityList;
	}

	public List<ResultDataCity> getCityByNameOrAdminName(String name) {
		List<IndexUnitCity> listOfCity = cityElasticRepository.findByNameOrAdminName(name,name);
		List<ResultDataCity> resultDataCityList = new ArrayList<>();
		for(IndexUnitCity indexUnitCity: listOfCity) {
			ResultDataCity resultDataCity = new ResultDataCity();
			resultDataCity.setAdminName(indexUnitCity.getAdminName());
			resultDataCity.setCountry(indexUnitCity.getCountry());
			resultDataCity.setGeoPoint(indexUnitCity.getGeoPoint());
			resultDataCity.setIso3(indexUnitCity.getIso3());
			resultDataCity.setName(indexUnitCity.getName());
			resultDataCity.setNameAscii(indexUnitCity.getNameAscii());
			resultDataCity.setId(indexUnitCity.getId());
			resultDataCityList.add(resultDataCity);
		}

		return resultDataCityList;
	}


	public List<ResultDataCity> getCityByNameOrAsciiName(String name) {
		List<IndexUnitCity> listOfCity = cityElasticRepository.findByNameOrNameAscii(name,name);
		List<ResultDataCity> resultDataCityList = new ArrayList<>();
		for(IndexUnitCity indexUnitCity: listOfCity) {
			ResultDataCity resultDataCity = new ResultDataCity();
			resultDataCity.setAdminName(indexUnitCity.getAdminName());
			resultDataCity.setCountry(indexUnitCity.getCountry());
			resultDataCity.setGeoPoint(indexUnitCity.getGeoPoint());
			resultDataCity.setIso3(indexUnitCity.getIso3());
			resultDataCity.setName(indexUnitCity.getName());
			resultDataCity.setNameAscii(indexUnitCity.getNameAscii());
			resultDataCity.setId(indexUnitCity.getId());
			resultDataCityList.add(resultDataCity);
		}

		return resultDataCityList;
	}


	public List<ResultDataEvent> getGeoPointSearch(QueryBuilder queryBuilder) throws Exception{
		List<ResultDataEvent> resultDataEvents = new ArrayList<>();
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		SearchRequest searchRequest = new SearchRequest("event");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

		searchSourceBuilder.query(queryBuilder);
		searchRequest.source(searchSourceBuilder);

		SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		SearchHit[] hits = searchResponse.getHits().getHits();
		for(SearchHit searchHit: hits){
			ResultDataEvent resultDataEvent = objectMapper.readValue(searchHit.getSourceAsString(),ResultDataEvent.class);
			resultDataEvents.add(resultDataEvent);
		}

		return resultDataEvents;
	}


	public List<ResultDataCity> getCityByNameOrAminNameOrNameAscii(String name) {

		List<IndexUnitCity> listOfCity = cityElasticRepository.findByNameOrAdminNameOrNameAscii(name,name,name);
		List<ResultDataCity> resultDataCityList = new ArrayList<>();
		for(IndexUnitCity indexUnitCity: listOfCity) {
			ResultDataCity resultDataCity = new ResultDataCity();
			resultDataCity.setAdminName(indexUnitCity.getAdminName());
			resultDataCity.setCountry(indexUnitCity.getCountry());
			resultDataCity.setGeoPoint(indexUnitCity.getGeoPoint());
			resultDataCity.setIso3(indexUnitCity.getIso3());
			resultDataCity.setName(indexUnitCity.getName());
			resultDataCity.setNameAscii(indexUnitCity.getNameAscii());
			resultDataCity.setId(indexUnitCity.getId());
			resultDataCityList.add(resultDataCity);
		}

		return resultDataCityList;

	}
}
