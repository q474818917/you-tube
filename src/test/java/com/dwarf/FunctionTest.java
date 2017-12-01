package com.dwarf;

import java.util.Map;

import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dmai.bean.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/applicationContext*.xml" })
public class FunctionTest {
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Test
	public void test(){
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
		        .withQuery(QueryBuilders.matchAllQuery())
		        .build();
		
		//elasticsearchTemplate.typeExists("city", "house");
		//elasticsearchTemplate.createIndex(City.class);
		//先createIndex,后putMapping
		
		IndexQuery indexQuery = new IndexQuery();
		/*indexQuery.setIndexName("city");
		indexQuery.setType("house");*/
		indexQuery.setId("123");
		City city = new City();
		city.setId("123");
		city.setName("北京");
		city.setUrl("http://www.baidu.com");
		indexQuery.setObject(city);
		elasticsearchTemplate.index(indexQuery);
		
		//elasticsearchTemplate.deleteIndex(City.class);
	}
	
	
}
