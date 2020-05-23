package org.andou.MCIP.services;

import java.util.Date;
import java.util.List;

import org.andou.MCIP.Metier.MentionMetier;
import org.andou.MCIP.Metier.PageMention;
import org.andou.MCIP.entities.Mention;
import org.andou.MCIP.entities.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MentionRestService {
	@Autowired
	private MentionMetier mentionMetier;
	
	@GetMapping(path="/afficherObservationMention/{numeroMention}")
	public Observation afficherObservationMention(@PathVariable("numeroMention") Long numeroMention) {
		return mentionMetier.afficherObservationMention(numeroMention);
	}


	@PostMapping(path="/faireObservation/{numeroMention}")
	public void faireObservation(@PathVariable("numeroMention") long numeroMention,@RequestBody Observation observation) {
		mentionMetier.faireObservation(numeroMention, observation);
	}
	
    
	@GetMapping(path="/mentions")
	public PageMention getMentions(@RequestParam(name="page")int page, @RequestParam(name="size")int size) {
		return mentionMetier.getMentions(page, size);
	}
    @PostMapping(path="/mentions")
	public Mention saveMention( @RequestBody Mention mention) {
		return mentionMetier.saveMention(mention);
	}
    @GetMapping(path="/infosMention/{numeroMention}")
	public Mention infosMention(@PathVariable("numeroMention") Long numeroMention) {
		return mentionMetier.infosMention(numeroMention);
	}
    @GetMapping(path="/ListerMentionParDate")
	public List<Mention> mentionParDate(
			@RequestParam(name="dateMention") 
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateMention) {
		return mentionMetier.mentionParDate(dateMention);
	}
	

}
