package pl.pjatk.RentalService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.model.Movie;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){return new RestTemplate();}

}
