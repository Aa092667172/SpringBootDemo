package com.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    @Primary//指定主數據庫
    @ConfigurationProperties(prefix = "spring.datasource.gogo")
    public DataSource gogoDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean
    public NamedParameterJdbcTemplate gogo(
            @Qualifier("gogoDataSource") DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.webapp")
    public DataSource webAppDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public NamedParameterJdbcTemplate webApp(
            @Qualifier("webAppDataSource") DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
