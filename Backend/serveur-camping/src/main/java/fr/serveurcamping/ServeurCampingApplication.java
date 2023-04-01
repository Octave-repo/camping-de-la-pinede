package fr.serveurcamping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class ServeurCampingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeurCampingApplication.class, args);
	}

}
