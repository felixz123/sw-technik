package com.project.zulassungssystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZulassungssystemApplication {

	private static final Logger log = LoggerFactory.getLogger(ZulassungssystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ZulassungssystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
	return (args) -> {
		// save a few users
		repository.save(new User("Jack", "Bauer", "test@test.de", Roles.BEWERBER));
		repository.save(new User("Chloe", "O'Brian", "", Roles.UNTERSTUETZER));
		repository.save(new User("Kim", "Bauer", "", Roles.ZULASSUNGSAUSSCHUSS));
		repository.save(new User("David", "Palmer", "", Roles.BEWERBER));
		repository.save(new User("Michelle", "Dessler", "", Roles.UNTERSTUETZER));
  
		// fetch all users
		log.info("Users found with findAll():");
		log.info("-------------------------------");
		for (User user : repository.findAll()) {
		  	log.info(user.toString());
		}
		log.info("");
  
		// fetch an individual user by ID
		User user = repository.findById(1L);
		log.info("Users found with findById(1L):");
		log.info("--------------------------------");
		log.info(user.toString());
		log.info("");
  
		// fetch users by last name
		log.info("Users found with findByLastName('Bauer'):");
		log.info("--------------------------------------------");
		repository.findByLastName("Bauer").forEach(bauer -> {
		  	log.info(bauer.toString());
		});
		// for (User bauer : repository.findByLastName("Bauer")) {
		//  log.info(bauer.toString());
		// }
		log.info("");
	  	};
	}

}