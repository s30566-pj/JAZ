package pl.pjatk.RentalService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){return new RestTemplate();}

}
