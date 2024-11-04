package com.emsi.servicevoiture;

import com.emsi.servicevoiture.entities.Client;
import com.emsi.servicevoiture.entities.Voiture;
import com.emsi.servicevoiture.repositories.VoitureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ServiceVoitureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceVoitureApplication.class, args);
	}
	@Bean
	public CommandLineRunner start(VoitureRepository voitureRepository, ClientService clientService){
		return args ->{
			Client c1 = clientService.clientById(2L);
			Client c2 = clientService.clientById(1L);
			System.out.println("**************************");
			System.out.println("d est :" + c2.getId());
			System.out.println("Nom est :" + c2.getNom());
			System.out.println("**************************");
			System.out.println("**************************");
			System.out.println("Id est :" + c1.getId());
			System.out.println("Nom est :" + c1.getNom());
			System.out.println("Nom est :" + c1.getAge());
			System.out.println("**************************");
			voitureRepository.save(new Voiture(Long.parseLong("1"), "Toyota", "A 25 333",
					"Corolla", 1L, c2));

		};
	}
}
