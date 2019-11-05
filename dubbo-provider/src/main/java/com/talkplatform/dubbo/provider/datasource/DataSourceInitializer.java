package com.talkplatform.dubbo.provider.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceInitializer {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.course")
	public DbConf courseDbConf() {
		return new DbConf();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.course.write")
	public DbConf courseWriteDbConf() {
		return new DbConf();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.textbook")
	public DbConf textbookDbConf() {
		return new DbConf();
	}

	@Bean
	public DynamicDataSource dataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		Map<Object, Object> dataSourceMap = new HashMap<>();
		dataSourceMap.put("course", courseDbConf().dataSource());
		dataSourceMap.put("courseWrite", courseWriteDbConf().dataSource());
		dataSourceMap.put("textbook", textbookDbConf().dataSource());
		dynamicDataSource.setDefaultTargetDataSource(dataSourceMap.get("course"));
		dynamicDataSource.setTargetDataSources(dataSourceMap);
		return dynamicDataSource;
	}

}
