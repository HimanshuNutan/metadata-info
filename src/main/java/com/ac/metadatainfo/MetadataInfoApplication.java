package com.ac.metadatainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MetadataInfoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MetadataInfoApplication.class, args);
  }

}
