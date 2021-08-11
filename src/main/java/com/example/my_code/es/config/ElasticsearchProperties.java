package com.example.my_code.es.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Properties class for Elasticsearch
 *
 * @author alex
 * @since 2019/11/28
 */
@Data
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticsearchProperties {
    private String hosts;
}
