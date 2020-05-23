package org.andou.MCIP.Metier;

import java.util.List;

import org.andou.MCIP.entities.FormSusp;
import org.andou.MCIP.entities.Suspect;

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
	public String gareAvueLeSuspect(Long idSuspect);
	public String relaxerLeSuspect(Long idSuspect);
	public String reccherLeSuspect(Long idSuspect);
	public String defererLeSuspect(Long idSuspect);
	public Suspect ajouterEvenement(Long idSuspect,Long idEvenement);
}
 