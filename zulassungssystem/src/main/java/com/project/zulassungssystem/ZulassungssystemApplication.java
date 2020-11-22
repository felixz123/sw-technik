package com.project.zulassungssystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
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
		repository.save(new User("Jack", "Bauer", "test@test.de", "ROLE_BEWERBER", "lol"));
		repository.save(new User("Chloe", "O'Brian", "cobrian@test.de", "ROLE_BEWERBER", "rofl"));
		repository.save(new User("Kim", "Bauer", "kbauer@test.com", "ROLE_ZULASSUNG", "stfu"));
		repository.save(new User("David", "Palmer", "", "ROLE_BEWERBER", "pw"));
		repository.save(new User("Michelle", "Dessler", "mdressler@test.de", "ROLE_UNTERSTUETZER", "test"));
  
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