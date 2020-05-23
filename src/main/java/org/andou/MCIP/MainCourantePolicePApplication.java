package org.andou.MCIP;


import org.andou.MCIP.entities.Mention;
import org.andou.MCIP.entities.Personnel;
import org.andou.MCIP.entities.Suspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MainCourantePolicePApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(MainCourantePolicePApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Mention.class, Personnel.class, Suspect.class);
		
		
		
		
	}

}
