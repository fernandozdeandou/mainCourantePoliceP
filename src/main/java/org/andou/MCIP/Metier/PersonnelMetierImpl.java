package org.andou.MCIP.Metier;

import java.awt.print.Pageable;
import java.util.Date;
import org.andou.MCIP.dao.PersonnelRepository;
import org.andou.MCIP.entities.Mention;
import org.andou.MCIP.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class PersonnelMetierImpl implements PersonnelMetier {
	@Autowired
	private PersonnelRepository personnelRepository;

	@Override
	public Personnel savePersonnel(Personnel per) {
		per.setDatePriseService(new Date());
		per.setStatut("EN SERVICE");
		per.setPhotoProfil("unknown.jpg");
		return personnelRepository.save(per);
	}

	@Override
	public Personnel upDatePersonnel(Personnel per) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personnel infonsPersonnel(String matricule) {
		// TODO Auto-generated method stub
		return personnelRepository.findByMatricule(matricule);
	}
	
	@Override
	public PagePersonnel listerPersonnelParPage(int page, int size) {		
		PageRequest pageable = PageRequest.of(page, size, Sort.by("grade").ascending());
		Page<Personnel> per = personnelRepository.findAll(pageable);
		PagePersonnel pPer = new PagePersonnel();
		pPer.setPersonnel(per.getContent());
		pPer.setNombreOperation(per.getNumberOfElements());
		pPer.setPage(per.getNumber());
		pPer.setTotalPage(per.getTotalPages());
		pPer.setTotalOperation((int) per.getTotalElements());
		
		return pPer;
	}

	@Override
	public PagePersonnel listerPersonnelOperationnel(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by("grade").ascending());
		Page<Personnel> per = personnelRepository.personnelOperationnel(pageable);
		PagePersonnel pPer = new PagePersonnel();
		pPer.setPersonnel(per.getContent());
		pPer.setNombreOperation(per.getNumberOfElements());
		pPer.setPage(per.getNumber());
		pPer.setTotalPage(per.getTotalPages());
		pPer.setTotalOperation((int) per.getTotalElements());
		return pPer;
		}

	@Override
	public PagePersonnel listerPersonnelMalade(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by("grade").ascending());
		Page<Personnel> per = personnelRepository.personnelMalade(pageable);
		PagePersonnel pPer = new PagePersonnel();
		pPer.setPersonnel(per.getContent());
		pPer.setNombreOperation(per.getNumberOfElements());
		pPer.setPage(per.getNumber());
		pPer.setTotalPage(per.getTotalPages());
		pPer.setTotalOperation((int) per.getTotalElements());
		
		return pPer;
	}

	@Override
	public PagePersonnel listerPersonnelPermissionnaire(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by("grade").ascending());
		Page<Personnel> per = personnelRepository.personnelPermissionnaire(pageable);
		PagePersonnel pPer = new PagePersonnel();
		pPer.setPersonnel(per.getContent());
		pPer.setNombreOperation(per.getNumberOfElements());
		pPer.setPage(per.getNumber());
		pPer.setTotalPage(per.getTotalPages());
		pPer.setTotalOperation((int) per.getTotalElements());
		
		return pPer;
	}

	@Override
	public PagePersonnel ListerPersonnelEnConge(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by("grade").ascending());
		Page<Personnel> per = personnelRepository.personnelConge(pageable);
		PagePersonnel pPer = new PagePersonnel();
		pPer.setPersonnel(per.getContent());
		pPer.setNombreOperation(per.getNumberOfElements());
		pPer.setPage(per.getNumber());
		pPer.setTotalPage(per.getTotalPages());
		pPer.setTotalOperation((int) per.getTotalElements());
		
		return pPer;
	}

	@Override
	public void mettreEnConge(String matricle) {
		Personnel per=personnelRepository.findById(matricle).get();
		per.setStatut("EN CONGE");
		personnelRepository.save(per);
	}

	@Override
	public void mettreEnPermission(String matricle) {
		Personnel per=personnelRepository.findById(matricle).get();
		per.setStatut("PERMISSIONNAIRE");
		personnelRepository.save(per);
	}

	@Override
	public void rendreMalade(String matricle) {
		Personnel per=personnelRepository.findById(matricle).get();
		per.setStatut("MALADE");
		personnelRepository.save(per);
	}

	@Override
	public void rendreOperationnel(String matricle) {
		Personnel per=personnelRepository.findById(matricle).get();
		per.setStatut("EN SERVICE");
		personnelRepository.save(per);
	}

	@Override
	public void affecterPersonnel(String matricle) {
		Personnel per=personnelRepository.findById(matricle).get();
		per.setStatut("AFFECTE");
		personnelRepository.save(per);
	}

	@Override
	public PagePersonnel ListerPersonnelAffecte(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by("grade").ascending());
		Page<Personnel> per = personnelRepository.personnelAffecte(pageable);
		PagePersonnel pPer = new PagePersonnel();
		pPer.setPersonnel(per.getContent());
		pPer.setNombreOperation(per.getNumberOfElements());
		pPer.setPage(per.getNumber());
		pPer.setTotalPage(per.getTotalPages());
		pPer.setTotalOperation((int) per.getTotalElements());
		
		return pPer;
	}

}
