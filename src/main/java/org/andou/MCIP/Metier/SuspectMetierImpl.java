package org.andou.MCIP.Metier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		if (suspectRepository.existsByNumeroCni(suspect.getNumeroCni()))
		{ throw new
			  RuntimeException("Le suspect ayant la CNI N°"+suspect.getNumeroCni()+" est déjà enrégistré s'il vous plait!");
		 }
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
		if (!suspectRepository.existsByNumeroCni(cni))
		{ throw new
			  RuntimeException("le suspect ayant la CNI N°"+cni+" n'est pas encore enrégistré !");
		 }
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
		Suspect susp =  suspectRepository.findById(idSuspect).get();
		susp.setPosition("DEFERER");
		suspectRepository.save(susp);
		return "Suspect déféré avec succès";
	}
	@Override
	public List<Suspect> suspectLibre() {
		// TODO Auto-generated method stub
		return suspectRepository.suspectLibre();
	}

	@Override
	public List<Suspect> suspectDeferer() {
		// TODO Auto-generated method stub
		return suspectRepository.suspectDeferer();
	}

	@Override
	public Suspect ajouterEvenement(Long idSuspect, Long idEvenement) {
		if (!evenementRepository.existsById(idEvenement))
		{ throw new
			  RuntimeException("L'évènement N°"+idEvenement+" n'est pas encore enrégistré !");
		 }
		
		
		Evenement event = evenementRepository.findById(idEvenement).get();
		Suspect susp = suspectRepository.findById(idSuspect).get();
		List<Evenement> liEv = new ArrayList<Evenement>();
		liEv.addAll(susp.getEvenements());
		liEv.add(event);
		susp.setEvenements(liEv);
		suspectRepository.save(susp);
	return suspectRepository.findByIdSuspect(idSuspect); 
	}

	@Override
	public byte[] photoFace(Long id) {
		Suspect sus=suspectRepository.findById(id).get();
		String photoName=sus.getPhotoFace();
		File file=new File(System.getProperty("user.home")+"/MCIPPhotos/photoSuspects/"+photoName);
		Path path=Paths.get(file.toURI());
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public byte[] photoEntiere(Long id) {
		Suspect sus=suspectRepository.findById(id).get();
		String photoName=sus.getPhotoEntiere();
		File file=new File(System.getProperty("user.home")+"/MCIPPhotos/photoSuspects/"+photoName);
		Path path=Paths.get(file.toURI());
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public byte[] photoProfil(Long id) {
		Suspect sus=suspectRepository.findById(id).get();
		String photoName=sus.getPhotoProfil();
		File file=new File(System.getProperty("user.home")+"/MCIPPhotos/photoSuspects/"+photoName);
		Path path=Paths.get(file.toURI());
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
