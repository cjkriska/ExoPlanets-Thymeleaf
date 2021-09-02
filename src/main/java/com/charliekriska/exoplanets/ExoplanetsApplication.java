package com.charliekriska.exoplanets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ExoplanetsApplication {

    public static void main(String[] args) { SpringApplication.run(ExoplanetsApplication.class, args); }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
