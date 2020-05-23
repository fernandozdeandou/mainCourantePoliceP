package org.andou.MCIP.Metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.andou.MCIP.dao.EvenementRepository;
import org.andou.MCIP.dao.PersonnelRepository;
import org.andou.MCIP.dao.RequerentRepository;
import org.andou.MCIP.entities.Evenement;
import org.andou.MCIP.entities.FormEvent;
import org.andou.MCIP.entities.Personnel;
import org.andou.MCIP.entities.Requrent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EvenementMetierImpl implements EvenementMetier{
	
	@Autowired
	private EvenementRepository evenementRepository;
	@Autowired
	private PersonnelRepository personnelRepository;
	@Autowired
	private RequerentRepository requerentRepository;

	@Override
	@Transactional
	public Evenement saveEvenement(FormEvent eve) {
		Personnel enq = personnelRepository.findById(eve.getMatriEnqueteur()).get();
		Requrent req = requerentRepository.findById(eve.getIdREquerent()).get();
		Evenement event = new Evenement();
		
	//	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

	///	String dateInString = "7-Jun-2013";
		//Date date = formatter.parse(dateInString);
		
		event.setDate(eve.getDate());
		event.setEnqueteur(enq);
		event.setHeureEvenement(eve.getHeureEvenement());
		event.setLieuEvenement(eve.getLieuEvenement());
		event.setNomEvenement(eve.getNomEvenement());
		event.setRequerent(req);
		event.setSaisine(eve.getSaisine());
		evenementRepository.save(event);
		return event ;
	}

	@Override
	public Page<Evenement> listeEvenement(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("idEvenement").descending());
		return evenementRepository.findAll(pageable);
	}

	@Override
	public List<Evenement> listerEvenementParDate(Date date) {
		// TODO Auto-generated method stub
		return evenementRepository.findByDate(date);
	}

	@Override
	public Evenement infosEvenement(Long idEvenement) {
		// TODO Auto-generated method stub
		return evenementRepository.findByIdEvenement(idEvenement);
	}

}
