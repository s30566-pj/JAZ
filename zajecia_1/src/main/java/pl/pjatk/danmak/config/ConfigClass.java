package pl.pjatk.danmak.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.danmak.pojo.ConditionalBean;
import pl.pjatk.danmak.pojo.Pojoclass;

import java.util.List;

@Configuration
public class ConfigClass {
    @Bean
    public Pojoclass pojoclass(){
        return new Pojoclass(5, "test");
    }

    @Bean
    public List<String> defaultData(){
        return List.of("jeden","dwa","trzy","co jest dalej?", "nie wiem");
    }

    @Bean
    @ConditionalOnProperty(
            name = "init.custom.property",
            havingValue = "true",
            matchIfMissing = false
    )
    public ConditionalBean conditionalBean(){
        return new ConditionalBean();
    }
}
