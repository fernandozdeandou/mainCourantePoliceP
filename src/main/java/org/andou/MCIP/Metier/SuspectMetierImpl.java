package org.andou.MCIP.Metier;

import java.util.ArrayList;
import java.util.List;

import org.andou.MCIP.dao.EvenementRepository;
import org.andou.MCIP.dao.SuspectRepository;
import org.andou.MCIP.entities.Evenement;
import org.andou.MCIP.entities.FormSusp;
import org.andou.MCIP.entities.Suspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuspectMetierImpl implements SuspectMetier {
	@Autowired
	private SuspectRepository suspectRepository;
	@Autowired
	private EvenementRepository evenementRepository;

	@Override
	public Suspect saveSuspect(Suspect suspect) {
		suspect.setPhotoEntiere("photoEntiere.png");
		suspect.setPhotoFace("photoFace.jpg");
		suspect.setPhotoProfil("photoProfil.png");
		suspect.setPosition("LIBRE");
		return suspectRepository.save(suspect);
	}

	@Override
	public Suspect upDateSuspect(Suspect sus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Suspect> listSuspect() {
		// TODO Auto-generated method stub
		return suspectRepository.findAll();
	}

	@Override
	public Suspect infonsSuspect(Long idSuspect) {
		return suspectRepository.findByIdSuspect(idSuspect);
	}

	@Override
	public List<Suspect> chercherSuspectParNomprenem (String mc){
		return suspectRepository.findByNomPrenomContains(mc);
	}
	@Override
	public Suspect infosSuspectParNumeroCni(String cni) {
		return suspectRepository.findByNumeroCni(cni);
	}

	@Override
	public List<Suspect> suspectsGarderAvue() {
		return suspectRepository.suspectGarderAvue();
	}

	@Override
	public List<Suspect> suspectRechercher() {
		return suspectRepository.suspectRechercher();
	}

	@Override
	public String gareAvueLeSuspect(Long idSuspect) {
		Suspect susp =suspectRepository.findById(idSuspect).get();
		susp.setPosition("GARDER A VUE");
		suspectRepository.save(susp);	
		return "Suspect gardé à vue avec succès";
	}

	@Override
	public String relaxerLeSuspect(Long idSuspect) {
		Suspect susp =suspectRepository.findById(idSuspect).get();
		susp.setPosition("LIBRE");
		suspectRepository.save(susp);	
		return "Suspect relaxé à vue avec succès";
		
	}

	@Override
	public String reccherLeSuspect(Long idSuspect) {
		Suspect susp =suspectRepository.findById(idSuspect).get();
		susp.setPosition("EN FUITE");
		suspectRepository.save(susp);
		return "Suspect  à rechercher";
	}

	@Override
	public String defererLeSuspect(Long idSuspect) {
		Suspect susp =suspectRepository.findById(idSuspect).get();
		susp.setPosition("DEFERER");
		suspectRepository.save(susp);
		return "ok";
	}

	@Override
	public List<Suspect> suspectDeferer() {
		// TODO Auto-generated method stub
		return suspectRepository.suspectDeferer();
	}

	@Override
	public Suspect ajouterEvenement(Long idSuspect, Long idEvenement) {
	Evenement event = evenementRepository.findById(idEvenement).get();
	Suspect susp = suspectRepository.findById(idSuspect).get();
	List<Evenement> liEv = new ArrayList<Evenement>();
	liEv.addAll(susp.getEvenements());
	liEv.add(event);
	susp.setEvenements(liEv);
	suspectRepository.save(susp);
	return suspectRepository.findByIdSuspect(idSuspect); 
	}

}
