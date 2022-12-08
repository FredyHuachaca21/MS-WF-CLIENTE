package com.pe.fredgar.mswfclient.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Value("${config.base.path.endpoint}")
    private String baseUrl;

    @Bean
    public WebClient webClient(){
        return WebClient.create(baseUrl);
    }

}
