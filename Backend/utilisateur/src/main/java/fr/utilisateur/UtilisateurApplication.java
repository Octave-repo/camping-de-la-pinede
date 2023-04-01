package fr.utilisateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableDiscoveryClient
public class UtilisateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilisateurApplication.class, args);
	}

}
