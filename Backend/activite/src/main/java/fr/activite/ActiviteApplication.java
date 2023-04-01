package fr.activite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableDiscoveryClient
public class ActiviteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiviteApplication.class, args);
	}

}
