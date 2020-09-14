package org.andou.MCIP.Metier;

import java.util.List;

import org.andou.MCIP.entities.FormSusp;
import org.andou.MCIP.entities.Suspect;
import org.springframework.web.bind.annotation.PathVariable;

public interface SuspectMetier {
	public Suspect saveSuspect(Suspect sus);
	public Suspect upDateSuspect(Suspect sus);
	public List<Suspect> listSuspect();
	public Suspect infonsSuspect(Long idSuspect);
	public List<Suspect> chercherSuspectParNomprenem(String mc);
	public Suspect infosSuspectParNumeroCni(String cni);
	public List<Suspect> suspectsGarderAvue();
	public List<Suspect> suspectRechercher();
	public List<Suspect> suspectDeferer();
	public List<Suspect> suspectLibre();
	public String gareAvueLeSuspect(Long idSuspect);
	public String relaxerLeSuspect(Long idSuspect);
	public String reccherLeSuspect(Long idSuspect);
	public String defererLeSuspect(Long idSuspect);
	public Suspect ajouterEvenement(Long idSuspect,Long idEvenement);
	
	public byte[] photoFace (Long id);
	public byte[] photoEntiere( Long id);
	public byte[] photoProfil(Long id);
}
 