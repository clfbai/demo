package com.example.my_code;


import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MatchPhrasePrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
public class EsTest {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    public String INDEX = "content";
    public String TYPE = "_doc";

    @Test
    public void add() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "15589");
        map.put("name", "詹三");
        map.put("age", 22);
        map.put("userNo", "9527");
        try {
            IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, map.get("id").toString()).source(map);
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println(indexResponse.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void search() {
        SearchRequest searchRequest = new SearchRequest().indices(INDEX).types(TYPE);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        MatchPhrasePrefixQueryBuilder mppqb = QueryBuilders.matchPhrasePrefixQuery("name", "测试");
        sourceBuilder.query(mppqb);
        try {
            SearchResponse sr = this.restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            String result = sr.toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void update() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "20190909");
        map.put("name", "测试-update");
        map.put("age", 22);
        try {
            UpdateRequest request = new UpdateRequest(INDEX, TYPE, map.get("id").toString()).doc(map);
            UpdateResponse updateResponse = restHighLevelClient.update(request, RequestOptions.DEFAULT);
            System.out.println(updateResponse.toString());
        } catch (Exception e) {

        }
    }

    @Test
    public void get() {
        try {
            GetRequest request = new GetRequest(INDEX, TYPE, "20190909");
            GetResponse getResponse = this.restHighLevelClient.get(request, RequestOptions.DEFAULT);
            System.out.println( getResponse.getSource().toString());
        } catch (Exception e) {

        }
    }

    @Test
    public void delete() {
        try {
            DeleteRequest request = new DeleteRequest(INDEX, TYPE, "20190909");
            DeleteResponse deleteResponse = this.restHighLevelClient.delete(request, RequestOptions.DEFAULT);
            System.out.println(deleteResponse.toString());
        } catch (Exception e) {

        }
    }


}
