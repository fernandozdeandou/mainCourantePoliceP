package org.andou.MCIP;

import org.andou.MCIP.Metier.UserMetier;
import org.andou.MCIP.dao.RoleRepository;
import org.andou.MCIP.dao.UserRepository;
import org.andou.MCIP.entities.ERole;
import org.andou.MCIP.entities.Mention;
import org.andou.MCIP.entities.Personnel;
import org.andou.MCIP.entities.Role;
import org.andou.MCIP.entities.Suspect;
import org.andou.MCIP.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MainCourantePolicePApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserMetier userMetier;
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MainCourantePolicePApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Mention.class, Personnel.class, Suspect.class);
		
		/*
		 * Role r1=new Role(); Role r2=new Role(); Role r3=new Role(); Role r4=new
		 * Role(); r1.setName(ERole.ROLE_USER); r2.setName(ERole.ROLE_CHEF);
		 * r3.setName(ERole.ROLE_ADMIN); r4.setName(ERole.ROLE_SMCIP);
		 * roleRepository.save(r1); roleRepository.save(r2); roleRepository.save(r3);
		 * roleRepository.save(r4);
		 */		
		//userMetier.addRoleAdmin("703495-M");
		
	}

}
