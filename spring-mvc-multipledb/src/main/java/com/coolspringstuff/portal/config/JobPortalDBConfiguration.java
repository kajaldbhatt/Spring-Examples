package com.coolspringstuff.portal.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.portal")
@PropertySource(value = { "classpath:Application.properties" })
public class JobPortalDBConfiguration {
	
	@Autowired
    private Environment env;

 
    @Bean(name = "dsJobPortal")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.jobPortalDriverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.jobPortalUrl"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.jobPortalUsername"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.jobPortalPassword"));
        return dataSource;
    }
 
    @Bean(name = "jdbcJobPortal")
    public JdbcTemplate jdbcTemplate(@Qualifier("dsJobPortal") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
    }
 
}
