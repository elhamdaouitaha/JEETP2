package com.emsi.client;

import com.emsi.client.entities.Client;
import com.emsi.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	@Bean
	CommandLineRunner initialiserBaseH2(ClientRepository clientRepository) {
		return args -> {
			clientRepository.save(new Client(null, "Oubna", "Yass", 23f));
			clientRepository.save(new Client(null, "Benani", "RAMI", 22f));
			clientRepository.save(new Client(null, "Samir", "Aya", 22f));
		};
	}

}
