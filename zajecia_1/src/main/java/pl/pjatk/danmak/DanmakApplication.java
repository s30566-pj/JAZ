package pl.pjatk.danmak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import pl.pjatk.danmak.config.ConfigProperties;

@ImportResource("classpath:config.xml")
@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class DanmakApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanmakApplication.class, args);
	}

}
