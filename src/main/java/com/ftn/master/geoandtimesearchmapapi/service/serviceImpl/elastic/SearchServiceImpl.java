package com.ftn.master.geoandtimesearchmapapi.service.serviceImpl.elastic;

import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.GeoAndTimeQuery;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.ResultDataCity;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.ResultDataDTO;
import com.ftn.master.geoandtimesearchmapapi.domain.lcuene.ResultDataEvent;
import com.ftn.master.geoandtimesearchmapapi.service.lucene.search.ResultRetriever;
import com.ftn.master.geoandtimesearchmapapi.service.elastic.SearchService;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
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
        ResultDataCity resultDataCity;
        if(!geoAndTimeQuery.getCountryName().equals("")){
            resultDataCity = getCityByNameAndCountry(geoAndTimeQuery.getCityName(),geoAndTimeQuery.getCountryName());
        }else {
            resultDataCity = getCityByNameOrAdminNameOrNameAscii(geoAndTimeQuery.getCityName());
        }


        if(geoAndTimeQuery.getStartDate() == null)
            geoAndTimeQuery.setStartDate(new Date());



        if(resultDataCity.getGeoPoint()==null){
            return new ResultDataDTO();
        }
        if(geoAndTimeQuery.getEndDate()!= null) {
            if (geoAndTimeQuery.getStartDate().equals(geoAndTimeQuery.getEndDate())) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(geoAndTimeQuery.getEndDate());
                calendar.add(Calendar.DAY_OF_MONTH, 1);
                geoAndTimeQuery.setEndDate(calendar.getTime());
            }
        }

        resultDataDTO.setName(resultDataCity.getName());
        resultDataDTO.setGeoPoint(resultDataCity.getGeoPoint());
        QueryBuilder queryBuilderGeo = QueryBuilders.geoDistanceQuery("geoPoint").distance(20, DistanceUnit.KILOMETERS).point(new GeoPoint(resultDataCity.getGeoPoint().getLat(),resultDataCity.getGeoPoint().getLon()));
        QueryBuilder queryBuilderDate = QueryBuilders.rangeQuery("eventDate").gte(geoAndTimeQuery.getStartDate()).lte(geoAndTimeQuery.getEndDate());
        QueryBuilder queryBuilderApproved = QueryBuilders.matchQuery("approved",true);
        QueryBuilder queryBuilderBoolQuery = QueryBuilders.boolQuery().must(queryBuilderGeo).must(queryBuilderApproved).must(queryBuilderDate);

        QueryBuilder dateNullQuery = QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("eventDate")).must(queryBuilderGeo).must(queryBuilderApproved);

        QueryBuilder finalQuery = QueryBuilders.boolQuery().should(queryBuilderBoolQuery).should(dateNullQuery);

        if(geoAndTimeQuery.getCategory()!=null){
            finalQuery = QueryBuilders.boolQuery().must(finalQuery).must(QueryBuilders.matchQuery("category",geoAndTimeQuery.getCategory()));
        }

        List<ResultDataEvent> resultDataEvents = resultRetriever.getGeoPointSearch(finalQuery);

        resultDataDTO.setResultDataEvents(resultDataEvents);

        return resultDataDTO;

    }

    @Override
    public List<ResultDataCity> getCityByNameOrNameAscii(String name) {
        return resultRetriever.getCityByNameOrAsciiName(name);
    }

    @Override
    public ResultDataCity getCityByNameOrAdminNameOrNameAscii(String name) {
        return resultRetriever.getCityByNameOrAminNameOrNameAscii(name);
    }

    @Override
    public ResultDataCity getCityByNameAndCountry(String name,String country) {
        return resultRetriever.getCityByNameAndCountry(name,country);
    }

    @Override
    public List<ResultDataCity> getCitiesStartWith(String name) {
        return resultRetriever.getCitiesStartWith(name);
    }

}
