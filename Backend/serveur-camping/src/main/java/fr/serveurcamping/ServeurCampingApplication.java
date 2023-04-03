package fr.serveurcamping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServeurCampingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeurCampingApplication.class, args);
	}

}
