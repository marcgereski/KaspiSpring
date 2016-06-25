package tst.kaspi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
//@SpringBootApplication
public class KaspiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaspiSpringApplication.class, args);
	}
}
