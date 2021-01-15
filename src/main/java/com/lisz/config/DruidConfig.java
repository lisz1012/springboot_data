package com.lisz.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource druidDataSource(){
		return new DruidDataSource();
	}

	@Bean
	public ServletRegistrationBean<Servlet> druidServletRegistrationBean(){
		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
		Map<String, String> initParams = new HashMap<>();
		initParams.put("loginUsername", "admin");
		initParams.put("loginPassword", "123456");
		initParams.put("allow", "");
		servletRegistrationBean.setInitParameters(initParams);
		return servletRegistrationBean;
	}

	// 过滤掉不必要的请求，不用这个过滤器也没关系
	@Bean
	public FilterRegistrationBean<Filter> webStatFilter(){
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new WebStatFilter());
		Map<String, String> initParams = new HashMap<>();
		initParams.put("exclusions", "*.js,*.css,/druid/*");
		bean.setInitParameters(initParams);
		return bean;
	}
}
