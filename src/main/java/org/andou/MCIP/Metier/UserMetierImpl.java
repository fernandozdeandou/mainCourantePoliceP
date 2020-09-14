package org.andou.MCIP.Metier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.andou.MCIP.dao.RoleRepository;
import org.andou.MCIP.dao.UserRepository;
import org.andou.MCIP.entities.ERole;
import org.andou.MCIP.entities.Role;
import org.andou.MCIP.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMetierImpl implements UserMetier {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<User> listeUtilisateur() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User addRoleAdmin(String matricule) {
		if (!userRepository.existsByUsername(matricule)){ throw new
			  RuntimeException("Le personnel matricule "+matricule+" n'est pas utilisateur ! ");
		 }
		
		User user = userRepository.findUserparMatricule(matricule);
		Set<Role> roles = new HashSet<>();
		Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(adminRole);
		
		user.setRoles(roles);
		userRepository.save(user);
		return user;

	}

	@Override
	public User addRoleChef(String matricule) {
		if (!userRepository.existsByUsername(matricule)){ throw new
			  RuntimeException("Le personnel matricule "+matricule+" n'est pas utilisateur ! ");
		 }
		
		User user = userRepository.findUserparMatricule(matricule);
		Set<Role> roles = new HashSet<>();
		Role adminRole = roleRepository.findByName(ERole.ROLE_CHEF)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(adminRole);
		
		user.setRoles(roles);
		userRepository.save(user);
		return user;
	}

	@Override
	public User addRoleSecretaire(String matricule) {
		if (!userRepository.existsByUsername(matricule)){ throw new
			  RuntimeException("Le personnel matricule "+matricule+" n'est pas utilisateur ! ");
		 }
		
		User user = userRepository.findUserparMatricule(matricule);
		Set<Role> roles = new HashSet<>();
		Role adminRole = roleRepository.findByName(ERole.ROLE_SMCIP)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(adminRole);
		
		user.setRoles(roles);
		userRepository.save(user);
		return user;
	}

	@Override
	public User addRoleUser(String matricule) {
		if (!userRepository.existsByUsername(matricule)){ throw new
			  RuntimeException("Le personnel matricule "+matricule+" n'est pas utilisateur ! ");
		 }
		
		User user = userRepository.findUserparMatricule(matricule);
		Set<Role> roles = new HashSet<>();
		Role adminRole = roleRepository.findByName(ERole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(adminRole);
		user.setRoles(roles);
		userRepository.save(user);
		return user;
	}

	@Override
	public User utilisateurParMatricule(String matricule) {
		if (!userRepository.existsByUsername(matricule)){ throw new
			  RuntimeException("L'utilisateur matricule "+matricule+" n'est pas enrégistrég ! ");
		 }
		return userRepository.findUserparMatricule(matricule);
	}

}
