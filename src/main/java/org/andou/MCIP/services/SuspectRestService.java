package org.andou.MCIP.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.andou.MCIP.Metier.SuspectMetier;
import org.andou.MCIP.dao.SuspectRepository;
import org.andou.MCIP.entities.Suspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/mcip/suspect")
public class SuspectRestService {
	@Autowired
	private SuspectMetier suspectMetier;
	
	@GetMapping(path="/photoEntiereSusp/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] photoEntiere(@PathVariable(name="id") Long id) {
		return suspectMetier.photoEntiere(id);
	}

	@GetMapping(path="/photoProfilSusp/{id}", produces=MediaType.IMAGE_JPEG_VALUE)
	public byte[] photoProfil(@PathVariable(name="id") Long id) {
		return suspectMetier.photoProfil(id);
	}


	@GetMapping(path="/photoFaceSusp/{id}", produces=MediaType.IMAGE_JPEG_VALUE)
	// @PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")		
    public byte[] photoFace(@PathVariable(name="id")Long id) {
		return suspectMetier.photoFace(id);
	}
    

	@GetMapping(path="/ajouterEvenement")
    @PreAuthorize(" hasRole('SMCIP')")
	public Suspect ajouterEvenement(@RequestParam(name="idSuspect")Long idSuspect,@RequestParam(name="idEvenement") Long idEvenement) {
		return suspectMetier.ajouterEvenement(idSuspect, idEvenement);
	}

	@GetMapping(path="/listSuspectDeferer")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public List<Suspect> suspectDeferer() {
		return suspectMetier.suspectDeferer();
	}
	@GetMapping(path="/listSuspectLibre")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public List<Suspect> suspectLibre() {
		return suspectMetier.suspectLibre();
	}


	@GetMapping(path="/defererLeSuspect/{idSuspect}")
	@PreAuthorize(" hasRole('SMCIP')")
	public String defererLeSuspect(@PathVariable(name="idSuspect") Long idSuspect) {
		return suspectMetier.defererLeSuspect(idSuspect);
	}

	@GetMapping(path="/garderAvueLeSuspect/{idSuspect}")
	@PreAuthorize(" hasRole('SMCIP')")
	public void gareAvueLeSuspect(@PathVariable(name="idSuspect") Long idSuspect) {
		suspectMetier.gareAvueLeSuspect(idSuspect);
	}

	@GetMapping(path="/relaxerLeSuspect/{idSuspect}")
	@PreAuthorize(" hasRole('SMCIP')")
	public void relaxerLeSuspect(@PathVariable(name="idSuspect") Long idSuspect) {
		suspectMetier.relaxerLeSuspect(idSuspect);
	}

	@GetMapping(path="/rechercherLeSuspect/{idSuspect}")
	@PreAuthorize(" hasRole('SMCIP')")
	public void reccherLeSuspect(@PathVariable(name="idSuspect") Long idSuspect) {
		suspectMetier.reccherLeSuspect(idSuspect);
	}
	@Autowired
	private SuspectRepository suspectRepository;
	
	
	@GetMapping(path="/listSuspectRechercher")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public List<Suspect> suspectRechercher() {
		return suspectMetier.suspectRechercher();
	}
	
	@GetMapping(path="/listSuspectParNom/{motCle}")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public List<Suspect> chercherSuspectParNomprenem(@PathVariable(name="motCle") String motCle) {
		return suspectMetier.chercherSuspectParNomprenem(motCle);
	}
	@GetMapping(path="/infosSuspectParNumeroCni/{numeroCni}")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public Suspect infosSuspectParNumeroCni(@PathVariable(name="numeroCni") String cni) {
		return suspectMetier.infosSuspectParNumeroCni(cni);
	}
	
	@GetMapping(path="/suspectsGarderAvue")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public List<Suspect> suspectsGarderAvue() {
		return suspectMetier.suspectsGarderAvue();
	}
	
	@PostMapping(path="/suspects")
	@PreAuthorize("hasRole('SMCIP')")
	public Suspect saveSuspect(@RequestBody Suspect sus) {
		return suspectMetier.saveSuspect(sus);
	}

	public Suspect upDateSuspect(Suspect sus) {
		return suspectMetier.upDateSuspect(sus);
	}
	
	@GetMapping(path="/suspects")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public List<Suspect> listSuspect() {
		return suspectMetier.listSuspect();
	}
	
	@GetMapping(path="/infosSuspect/{idSuspect}")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public Suspect infonsSuspect(@PathVariable(name="idSuspect") Long idSuspect) {
		return suspectMetier.infonsSuspect(idSuspect);
	}
	
	
	@PostMapping(value="/uploadPhotoFace/{idSuspect}", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasRole('SMCIP')")
	public ResponseEntity<Object> uploadPhotoFace(@RequestParam("file")MultipartFile file, @PathVariable Long idSuspect) throws IOException{
		Suspect sus=suspectRepository.findById(idSuspect).get();
		sus.setPhotoFace(file.getOriginalFilename());
		File convertfile= new File(System.getProperty("user.home")+"/MCIPPhotos/photoSuspects/"+file.getOriginalFilename());
		convertfile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertfile);
		fout.write(file.getBytes());
		fout.close();
		suspectRepository.save(sus);
		return new ResponseEntity<>("file is uoloaded successfully",HttpStatus.OK);
	}
	@PostMapping(value="/uploadPhotoEntiere/{idSuspect}", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize(" hasRole('SMCIP')")
	public ResponseEntity<Object> uploadPhotoEntiere(@RequestParam("file") MultipartFile file, @PathVariable Long idSuspect) throws IOException{
		Suspect sus=suspectRepository.findById(idSuspect).get();
		sus.setPhotoEntiere(file.getOriginalFilename());
		File convertfile= new File(System.getProperty("user.home")+"/MCIPPhotos/photoSuspects/"+file.getOriginalFilename());
		convertfile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertfile);
		fout.write(file.getBytes());
		fout.close();
		suspectRepository.save(sus);
		return new ResponseEntity<>("file is uoloaded successfully",HttpStatus.OK);
	}
	@PostMapping(value="/uploadPhotoProfil/{idSuspect}", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public ResponseEntity<Object> uploadPhotoProfil(@RequestParam("file")MultipartFile file, @PathVariable Long idSuspect) throws IOException{
		Suspect sus=suspectRepository.findById(idSuspect).get();
		sus.setPhotoProfil(file.getOriginalFilename());
		File convertfile= new File(System.getProperty("user.home")+"/MCIPPhotos/photoSuspects/"+file.getOriginalFilename());
		convertfile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertfile);
		fout.write(file.getBytes());
		fout.close();
		suspectRepository.save(sus);
		return new ResponseEntity<>("file is uoloaded successfully",HttpStatus.OK);
	}
	
	 
}
