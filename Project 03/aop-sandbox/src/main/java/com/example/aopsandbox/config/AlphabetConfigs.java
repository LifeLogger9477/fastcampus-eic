package com.example.aopsandbox.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * author : ms.Lee
 * date   : 2024-03-03
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "site-url")
public class AlphabetConfigs {

  private String google;
  private String naver;
}
