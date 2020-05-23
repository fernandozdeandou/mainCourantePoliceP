package org.andou.MCIP.Metier;

import java.util.List;

import org.andou.MCIP.entities.Personnel;
import org.springframework.data.domain.Page;

public interface PersonnelMetier {
	public Personnel savePersonnel(Personnel per);
	public Personnel upDatePersonnel(Personnel per);
	public PagePersonnel listerPersonnelParPage(int page, int size);
	public PagePersonnel listerPersonnelOperationnel(int page, int size);
	public PagePersonnel listerPersonnelMalade(int page, int size);
	public PagePersonnel listerPersonnelPermissionnaire(int page, int size);
	public PagePersonnel ListerPersonnelEnConge(int page, int size);
	public Personnel infonsPersonnel(String matricule);
	public void mettreEnConge(String matricle);
	public void mettreEnPermission(String matricle);
	public void rendreMalade(String matricle);
	public void rendreOperationnel(String matricle);
	public void affecterPersonnel(String matricle);
	public PagePersonnel ListerPersonnelAffecte(int page, int size);
	
	
}
