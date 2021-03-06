package org.andou.MCIP.services;

import java.util.Date;
import java.util.List;

import org.andou.MCIP.Metier.EvenementMetier;
import org.andou.MCIP.entities.Evenement;
import org.andou.MCIP.entities.FormEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/mcip/event")
public class EvenementRestService {
	@Autowired
	private EvenementMetier evenementMetier;
	
	
	@GetMapping(path="/evenements")
	@PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public Page<Evenement> listeEvenement(@RequestParam int page,@RequestParam int size) {
		return evenementMetier.listeEvenement(page, size);
	}
	public List<Evenement> listerEvenementParDate(@RequestParam Date date) {
		return evenementMetier.listerEvenementParDate(date);
	}
	@PostMapping(path="/evenements")
	@PreAuthorize("hasRole('SMCIP')")
	public Evenement saveEvenement(@RequestBody FormEvent eve) {
	  return evenementMetier.saveEvenement(eve);
	}
    @GetMapping(path="/infosEvenement/{idEvenement}")
    @PreAuthorize("hasRole('USER') or hasRole('CHEF') or hasRole('ADMIN') or hasRole('SMCIP')")
	public Evenement infosEvenement(@PathVariable(name="idEvenement")Long idEvenement) {
		return evenementMetier.infosEvenement(idEvenement);
	}

}
