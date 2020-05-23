package org.andou.MCIP.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.andou.MCIP.Metier.PagePersonnel;
import org.andou.MCIP.Metier.PersonnelMetier;
import org.andou.MCIP.dao.PersonnelRepository;
import org.andou.MCIP.entities.Personnel;
import org.andou.MCIP.entities.Suspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
public class PersonnelRestService {
	@Autowired
	private PersonnelMetier personnelMetier;
	
	@GetMapping(path="/personnels")
	public PagePersonnel listerPersonnelParPage(@RequestParam(name="page")int page,@RequestParam(name="size") int size) {
		return personnelMetier.listerPersonnelParPage(page, size);
	}
	@GetMapping(path="/personnelOperationnel")
	public PagePersonnel listerPersonnelOperationnel(@RequestParam(name="page")int page,@RequestParam(name="size") int size) {
		return personnelMetier.listerPersonnelOperationnel(page, size);
	}
	@GetMapping(path="/personnelMalade")
	public PagePersonnel listerPersonnelMalade(@RequestParam(name="page")int page,@RequestParam(name="size") int size) {
		return personnelMetier.listerPersonnelMalade(page, size);
	}
	@GetMapping(path="/personnelPermissionnaire")
	public PagePersonnel listerPersonnelPermissionnaire(@RequestParam(name="page")int page,@RequestParam(name="size") int size) {
		return personnelMetier.listerPersonnelPermissionnaire(page, size);
	}
	@GetMapping(path="/personnelConge")
	public PagePersonnel ListerPersonnelEnConge(@RequestParam(name="page")int page,@RequestParam(name="size") int size) {
		return personnelMetier.ListerPersonnelEnConge(page, size);
	}
	@GetMapping(path="/mettrePersonnelEnConge/{matricule}")
	public void mettreEnConge(@PathVariable(name="matricule") String matricle) {
		personnelMetier.mettreEnConge(matricle);
	}
	@GetMapping(path="/mettrePersonnelEnPermission/{matricule}")
	public void mettreEnPermission(@PathVariable(name="matricule") String matricle) {
		personnelMetier.mettreEnPermission(matricle);
	}
	@GetMapping(path="/mettrePersonnelMalade/{matricule}")
	public void rendreMalade(@PathVariable(name="matricule") String matricle) {
		personnelMetier.rendreMalade(matricle);
	}
	@GetMapping(path="/mettrePersonnelOperationnel/{matricule}")
	public void rendreOperationnel(@PathVariable(name="matricule") String matricle) {
		personnelMetier.rendreOperationnel(matricle);
	}
	@GetMapping(path="/affecterPersonnel/{matricule}")
	public void affecterPersonnel(@PathVariable(name="matricule") String matricle) {
		personnelMetier.affecterPersonnel(matricle);
	}
    @GetMapping(path="/ListerPersonnelAffecte")
	public PagePersonnel ListerPersonnelAffecte(@RequestParam(name="page")int page,@RequestParam(name="size") int size) {
		return personnelMetier.ListerPersonnelAffecte(page, size);
	}

	@GetMapping(path="/detailPersonnel/{matri}")
	public Personnel infonsPersonnel(@PathVariable(name="matri") String matri) {
		return personnelMetier.infonsPersonnel(matri);
	}
	@Autowired
	private PersonnelRepository personnelRepository;
	
	@PostMapping(path="/personnel")
	public Personnel savePersonnel(@RequestBody Personnel per) {
		return personnelMetier.savePersonnel(per);
	}

	public Personnel upDatePersonnel(Personnel per) {
		return personnelMetier.upDatePersonnel(per);
	}
	
	/*@GetMapping(path="/clientsParPAge")
	public Page<Personnel> ListerParPage(@RequestParam int page,@RequestParam int size) {
		return personnelMetier.ListerParPage(page, size);
	}
*/
	@GetMapping(path="/imagePersonnel/{matri}", produces=MediaType.IMAGE_JPEG_VALUE)
	private byte[] image(@PathVariable(name="matri") String matri) throws Exception {
		Personnel p=personnelRepository.findById(matri).get();
		String photoName=p.getPhotoProfil();
		File file=new File(System.getProperty("user.home")+"/MCIPPhotos/imagesPersonnels/"+photoName);
		Path path=Paths.get(file.toURI());
		return Files.readAllBytes(path);
	}
	@PostMapping(value="/uploadPhotoProfilPerso/{matri}", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadPhotoProfil(@RequestParam("file")MultipartFile file, @PathVariable String matri) throws IOException{
		Personnel per=personnelRepository.findById(matri).get();
		per.setPhotoProfil(file.getOriginalFilename());
		File convertfile= new File(System.getProperty("user.home")+"/MCIPPhotos/imagesPersonnels/"+file.getOriginalFilename());
		convertfile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertfile);
		fout.write(file.getBytes());
		fout.close();
		personnelRepository.save(per);
		return new ResponseEntity<>("file is uoloaded successfully",HttpStatus.OK);
	}
}
