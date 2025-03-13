package pl.pjatk.danmak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:config.xml")

@SpringBootApplication
public class DanmakApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanmakApplication.class, args);
	}

}
