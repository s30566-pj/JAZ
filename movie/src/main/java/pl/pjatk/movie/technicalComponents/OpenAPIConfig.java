package pl.pjatk.movie.technicalComponents;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Movie API Documentation")
                        .version("1.0.0")
                        .description("REST API for managing a movie database.")
                        .contact(new Contact().name("Daniel").email("kontakt@domena.pl")));
    }
}
