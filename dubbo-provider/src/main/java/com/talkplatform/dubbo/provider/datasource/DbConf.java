package com.talkplatform.dubbo.provider.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DbConf {

	public static Logger logger = LoggerFactory.getLogger(DbConf.class);

	private String url;
	private String username;
	private String password;
	private String driver = "com.mysql.jdbc.Driver";
	private int init = 5;
	private int minIdle = 2;
	private int maxActive = 50;
	private int maxWait = 60000;
	private int timeBetweenEvictionRunsMillis = 5000;
	private int minEvictableIdleTimeMillis = 300000;
	private String validationQuery = "selcet 1";
	private boolean testWhileIdle = true;
	private boolean testOnBorrow = false;
	private boolean testOnReturn = false;
	private String filters = "stat";

	private DataSource source = null;

	public DataSource dataSource() {
		if (source != null) {
			return source;
		}
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(this.getUrl());
		datasource.setUsername(this.getUsername());
		datasource.setPassword(this.getPassword());
		datasource.setDriverClassName(this.getDriver());
		datasource.setInitialSize(this.getInit());
		datasource.setMinIdle(this.getMinIdle());
		datasource.setMaxActive(this.getMaxActive());
		datasource.setMaxWait(this.getMaxWait());
		datasource.setTimeBetweenEvictionRunsMillis(this.getTimeBetweenEvictionRunsMillis());
		datasource.setMinEvictableIdleTimeMillis(this.getMinEvictableIdleTimeMillis());
		datasource.setValidationQuery(this.getValidationQuery());
		datasource.setTestWhileIdle(this.isTestWhileIdle());
		datasource.setTestOnBorrow(this.isTestOnBorrow());
		datasource.setTestOnReturn(this.isTestOnReturn());
		try {
			datasource.setFilters(this.getFilters());
		} catch (SQLException e) {
			logger.error("druid configuration initialization filter", e);
		}
		return source = datasource;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getInit() {
		return init;
	}

	public void setInit(int init) {
		this.init = init;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public boolean isTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(boolean testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

}
