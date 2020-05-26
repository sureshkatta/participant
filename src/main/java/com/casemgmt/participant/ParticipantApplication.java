package com.casemgmt.participant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.casemgmt.participant.entities.Participant;
import com.casemgmt.participant.jpa.ParticipantRepository;

@SpringBootApplication
public class ParticipantApplication {

	private static final Logger log = LoggerFactory.getLogger(ParticipantApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ParticipantApplication.class);
	}

	@Bean
	public CommandLineRunner demo(ParticipantRepository repository) {
		return (args) -> { 
			// save a few customers
			repository.save(new Participant("Jack", "Bauer"));
			repository.save(new Participant("Chloe", "O'Brian"));
			repository.save(new Participant("Kim", "Bauer"));
			repository.save(new Participant("David", "Palmer"));
			repository.save(new Participant("Michelle", "Dessler"));

			// fetch all customers 
			log.info("Participants found with findAll():");
			log.info("-------------------------------");
			for (Participant participant : repository.findAll()) {
				log.info(participant.toString());
			}
			log.info("");

			// fetch an individual customer by ID 
			Participant participant = repository.findById(1L);
			log.info("Participant found with findById(1L):");
			log.info("--------------------------------");
			log.info(participant.toString());
			log.info("");

			// fetch customers by last name
			log.info("Participant found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));

			log.info("");

		};
	}

}
