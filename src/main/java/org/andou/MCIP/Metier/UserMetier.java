package org.andou.MCIP.Metier;

import java.util.List;

import org.andou.MCIP.entities.User;

public interface UserMetier {
	public List<User> listeUtilisateur();
	public User addRoleAdmin(String matricule);
	public User addRoleChef(String matricule);
	public User addRoleSecretaire(String matricule);
	public User addRoleUser(String matricule);
	public User utilisateurParMatricule(String matricule);
}
