package com.ac.metadatainfo.configuration;

import com.ac.metadatainfo.exception.RestResponseErrorHandler;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
public class MetadataConfiguration {
  @Autowired
  private ApplicationProperties properties;

  @Bean
  public RestTemplate restTemplate() {

    return
            new RestTemplateBuilder()
                    .errorHandler(new RestResponseErrorHandler())
                    .build();
  }

  @Bean
  public DataSource getDataSource() {

    HikariConfig config = new HikariConfig();
    config.setDriverClassName(properties.getDb().getDriverclassname());
    config.setJdbcUrl(properties.getDb().getUrl());
    config.setUsername(properties.getDb().getUsername());
    config.setPassword(properties.getDb().getPassword());
    config.setMinimumIdle(properties.getDb().getConnection().getMinimumidle());
    config.setConnectionTimeout(properties.getDb().getConnection().getConnectiontimeout());
    config.setIdleTimeout(properties.getDb().getConnection().getIdletimeout());
    config.setMaximumPoolSize(properties.getDb().getConnection().getMaxpoolsize());
    config.setMaxLifetime(properties.getDb().getConnection().getMaxlifetime());
    config.setAutoCommit(properties.getDb().getConnection().isAutocommit());

    return
            new
                    HikariDataSource(config);
  }

}

