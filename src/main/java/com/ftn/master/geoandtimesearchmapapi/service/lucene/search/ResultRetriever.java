package com.ftn.master.geoandtimesearchmapapi.service.lucene.search;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftn.master.geoandtimesearchmapapi.helper.ResultRetrieverMapperHelper;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.IndexUnitCity;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.ResultDataCity;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.ResultDataEvent;
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
			resultDataCityList.add(ResultRetrieverMapperHelper.resultDataCityFromIndex(indexUnitCity));
		}

		return resultDataCityList;
	}

	public List<ResultDataCity> getCityByNameOrAdminName(String name) {
		List<IndexUnitCity> listOfCity = cityElasticRepository.findByNameOrAdminName(name,name);
		List<ResultDataCity> resultDataCityList = new ArrayList<>();
		for(IndexUnitCity indexUnitCity: listOfCity) {
			resultDataCityList.add(ResultRetrieverMapperHelper.resultDataCityFromIndex(indexUnitCity));
		}

		return resultDataCityList;
	}


	public List<ResultDataCity> getCityByNameOrAsciiName(String name) {
		List<IndexUnitCity> listOfCity = cityElasticRepository.findByNameOrNameAscii(name,name);
		List<ResultDataCity> resultDataCityList = new ArrayList<>();
		for(IndexUnitCity indexUnitCity: listOfCity) {
			resultDataCityList.add(ResultRetrieverMapperHelper.resultDataCityFromIndex(indexUnitCity));
		}

		return resultDataCityList;
	}


	public List<ResultDataEvent> getGeoPointSearch(QueryBuilder queryBuilderBoolQuery) throws Exception{
		List<ResultDataEvent> resultDataEvents = new ArrayList<>();
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		SearchRequest searchRequest = new SearchRequest("event");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

		searchSourceBuilder.query(queryBuilderBoolQuery);
		searchRequest.source(searchSourceBuilder);
		searchSourceBuilder.size(100);


		SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		SearchHit[] hits = searchResponse.getHits().getHits();
		for(SearchHit searchHit: hits){
			ResultDataEvent resultDataEvent = objectMapper.readValue(searchHit.getSourceAsString(),ResultDataEvent.class);
			if (resultDataEvent.getEventDate()!=null) {
				resultDataEvent.setDate(resultDataEvent.getEventDate().toString());
			}
				resultDataEvents.add(resultDataEvent);
		}

		return resultDataEvents;
	}


	public ResultDataCity getCityByNameOrAminNameOrNameAscii(String name) {

		List<IndexUnitCity> listOfCity = cityElasticRepository.findByNameOrAdminNameOrNameAscii(name,name,name);
		List<ResultDataCity> resultDataCityList = new ArrayList<>();
		if(listOfCity.size()==0){
			return new ResultDataCity();
		}
		for(IndexUnitCity indexUnitCity: listOfCity) {
			resultDataCityList.add(ResultRetrieverMapperHelper.resultDataCityFromIndex(indexUnitCity));
		}

		return resultDataCityList.get(0);

	}

	public List<ResultDataCity> getCitiesStartWith(String name) {
		List<IndexUnitCity> listOfCities = cityElasticRepository.findByNameLikeOrAdminNameLikeOrNameAsciiLike(name,name,name);
		List<ResultDataCity> resultDataCityList = new ArrayList<>();
		for(IndexUnitCity indexUnitCity: listOfCities) {
			resultDataCityList.add(ResultRetrieverMapperHelper.resultDataCityFromIndex(indexUnitCity));
		}

		return resultDataCityList;
	}

    public ResultDataCity getCityByNameAndCountry(String name, String country) {
		List<IndexUnitCity> listOfCities = cityElasticRepository.findByNameAndCountry(name,country);
		if(listOfCities.size()==0)
			return new ResultDataCity();

		List<ResultDataCity> resultDataCityList = new ArrayList<>();

		for(IndexUnitCity indexUnitCity: listOfCities)
			resultDataCityList.add(ResultRetrieverMapperHelper.resultDataCityFromIndex(indexUnitCity));

		return resultDataCityList.get(0);

    }
}
