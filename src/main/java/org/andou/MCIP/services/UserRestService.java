package org.andou.MCIP.services;

import java.util.List;

import org.andou.MCIP.Metier.UserMetier;
import org.andou.MCIP.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/mcip/users")
public class UserRestService {
	@Autowired
	private UserMetier userMetier;
	
	@GetMapping(path="/Utilisateur/{matricule}")
	@PreAuthorize(" hasRole('ADMIN')")
	public User utilisateurParMatricule(@PathVariable(name="matricule") String matricule) {
		return userMetier.utilisateurParMatricule(matricule);
	}
	@GetMapping(path="/listeUtilisateur")
	@PreAuthorize(" hasRole('ADMIN')")
	public List<User> listeUtilisateur() {
		return userMetier.listeUtilisateur();
	}
	@GetMapping(path="/addRoleAdmin/{matricule}")
	@PreAuthorize(" hasRole('ADMIN')")
	public User addRoleAdmin(@PathVariable(name="matricule")String matricule) {
		return userMetier.addRoleAdmin(matricule);
	}
	
	@GetMapping(path="/addRoleChef/{matricule}")
	@PreAuthorize(" hasRole('ADMIN')")
	public User addRoleChef(@PathVariable(name="matricule") String matricule) {
		return userMetier.addRoleChef(matricule);
	}
	@GetMapping(path="/addRoleSecretaire/{matricule}")
	@PreAuthorize(" hasRole('ADMIN')")
	public User addRoleSecretaire( @PathVariable(name="matricule") String matricule) {
		return userMetier.addRoleSecretaire(matricule);
	}
	@GetMapping(path="/addRoleUser/{matricule}")
	@PreAuthorize(" hasRole('ADMIN')")
	public User addRoleUser(@PathVariable(name="matricule") String matricule) {
		return userMetier.addRoleUser(matricule);
	}

}
