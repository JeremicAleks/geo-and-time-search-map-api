package com.ftn.master.geoandtimesearchmapapi.service.serviceImpl.elastic;

import com.ftn.master.geoandtimesearchmapapi.lucene.model.*;
import com.ftn.master.geoandtimesearchmapapi.lucene.search.ResultRetriever;
import com.ftn.master.geoandtimesearchmapapi.service.elastic.SearchService;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private final ResultRetriever resultRetriever;

    public SearchServiceImpl(ResultRetriever resultRetriever) {
        this.resultRetriever = resultRetriever;
    }

    @Override
    public List<ResultDataCity> getCityByName(String name) {
        return resultRetriever.getCityByName(name);
    }

    @Override
    public List<ResultDataCity> getCityByNameOrAdminName(String name) {
        return resultRetriever.getCityByNameOrAdminName(name);
    }

    @Override
    public ResultDataDTO geoAndTimeSearch(GeoAndTimeQuery geoAndTimeQuery) throws Exception {
        ResultDataDTO resultDataDTO = new ResultDataDTO();
        ResultDataCity resultDataCity = getCityByNameOrAdminNameOrNameAscii(geoAndTimeQuery.getCityName()).get(0);
        resultDataDTO.setName(resultDataCity.getName());
        resultDataDTO.setGeoPoint(resultDataCity.getGeoPoint());
        QueryBuilder queryBuilder = QueryBuilders.geoDistanceQuery("geoPoint").distance(50, DistanceUnit.KILOMETERS).point(new GeoPoint(resultDataCity.getGeoPoint().getLat(),resultDataCity.getGeoPoint().getLon()));
        QueryBuilder queryBuilderDate = QueryBuilders.rangeQuery("eventDate").gte(geoAndTimeQuery.getStartDate()).lte(geoAndTimeQuery.getEndDate());
        QueryBuilder queryBuilderApproved = QueryBuilders.matchQuery("approved",true);
        QueryBuilder queryBuilderMustNot = QueryBuilders.boolQuery().must(queryBuilder).must(queryBuilderDate).must(queryBuilderApproved);

        List<ResultDataEvent> resultDataEvents = resultRetriever.getGeoPointSearch(queryBuilderMustNot);

        resultDataDTO.setResultDataEvents(resultDataEvents);

//        for(ResultDataEvent resultDataEvent : resultDataEvents){
//            ResultDataEventDTO resultDataEventDTO = new ResultDataEventDTO();
//            resultDataEventDTO.setName(resultDataEvent.getName());
//            resultDataEventDTO.setGeoPoint(resultDataEvent.getGeoPoint());
//            resultDataEventDTO.setEventDate(resultDataEvent.getEventDate());
//            resultDataDTO.getResultDataEvents().add(resultDataEventDTO);
//        }

        return resultDataDTO;

    }

    @Override
    public List<ResultDataCity> getCityByNameOrNameAscii(String name) {
        return resultRetriever.getCityByNameOrAsciiName(name);
    }

    @Override
    public List<ResultDataCity> getCityByNameOrAdminNameOrNameAscii(String name) {
        return resultRetriever.getCityByNameOrAminNameOrNameAscii(name);
    }
}
