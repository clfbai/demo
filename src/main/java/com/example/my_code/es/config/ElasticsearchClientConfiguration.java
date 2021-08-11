package com.example.my_code.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Client bean configuration
 *
 * @author alex
 * @since 2019/11/28
 */
@Configuration
@EnableConfigurationProperties(ElasticsearchProperties.class)
 public class ElasticsearchClientConfiguration implements FactoryBean<RestHighLevelClient>, InitializingBean, DisposableBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchClientConfiguration.class);
    private final ElasticsearchProperties properties;
   private RestHighLevelClient instance;

    public ElasticsearchClientConfiguration(ElasticsearchProperties properties) {
        this.properties = properties;
    }

    @Override
    public void destroy() {
        try {
            LOGGER.info("Closing elasticsearch rest high-level client...");
            if (instance != null) {
                instance.close();
                instance = null;
            }
        } catch (final Exception e) {
            LOGGER.error("Error close elasticsearch rest high-level client: ", e);
        }
    }

    @Override
    public RestHighLevelClient getObject() {
        return instance;
    }

    @Override
    public Class<RestHighLevelClient> getObjectType() {
        return RestHighLevelClient.class;
    }

    @Override
    public void afterPropertiesSet() {
        buildClient();
    }

    protected void buildClient() {
        LOGGER.info("Building elasticsearch rest high-level client...");
        HttpHost[] hosts = Arrays.stream(properties.getHosts().split(","))
                .map(HttpHost::create)
                .toArray(HttpHost[]::new);
        if (hosts.length == 0) {
            throw new IllegalStateException("Property [elasticsearch.host] cannot be null");
        }
        this.instance = new RestHighLevelClient(
                RestClient.builder(hosts));
    }
}
