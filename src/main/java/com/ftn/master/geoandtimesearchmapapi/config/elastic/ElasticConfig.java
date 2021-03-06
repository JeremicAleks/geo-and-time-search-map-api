package com.ftn.master.geoandtimesearchmapapi.config.elastic;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticConfig extends AbstractElasticsearchConfiguration {

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration =
                ClientConfiguration
                        .builder()
                        .connectedTo("localhost:9200")
                        .build();

        return RestClients.create(clientConfiguration).rest();

    }

//    @Bean
//    public JestClient jestClient() {
//        JestClientFactory factory = new JestClientFactory();
//        factory.setHttpClientConfig(
//                new HttpClientConfig.Builder("http://localhost:9200")
//                        .multiThreaded(true)
//                        .defaultMaxTotalConnectionPerRoute(2)
//                        .maxTotalConnection(10)
//                        .build());
//        return factory.getObject();
//    }

}
