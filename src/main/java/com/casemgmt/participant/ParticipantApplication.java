package com.casemgmt.participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.casemgmt.participant.entities.Address;
import com.casemgmt.participant.entities.EmailAddress;
import com.casemgmt.participant.entities.Participant;
import com.casemgmt.participant.entities.PhoneNumber;
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

			Participant[] persons = 
			IntStream.range(0, 15).mapToObj(i -> {
				Participant participant = new Participant();
				participant.setFirstName("FN" + i);
				participant.setLastName("LN" + i);
				
				Address address = 
						Address.builder().street1(i + "01 Main").street2("Street").city("Cary").state("NC").zipCode("27519").addressType("Home").build();
				List<Address> addresses = new ArrayList<>();
				addresses.add(address);
				participant.setAddresses(addresses);
				
				PhoneNumber phoneNumber = 
						PhoneNumber.builder().phoneType("Cell").phone("240-232-23"+i).build();
				List<PhoneNumber> phoneNumbers = new ArrayList<>();
				phoneNumbers.add(phoneNumber);
				participant.setPhoneNumbers(phoneNumbers);
				
				EmailAddress emailAddress = 
						EmailAddress.builder().email("FN" + i + "@gmail.com").build();
				List<EmailAddress> emailAddresses = new ArrayList<>();
				emailAddresses.add(emailAddress);
				participant.setEmailAddresses(emailAddresses);
				
				return participant;
			}).toArray(Participant[]::new);

			Arrays.asList(persons).forEach((participant) -> repository.save(participant));
		};
	}
}
