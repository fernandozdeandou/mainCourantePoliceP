package org.andou.MCIP.Metier;

import java.util.Date;
import java.util.List;

import org.andou.MCIP.dao.MentionRepository;
import org.andou.MCIP.dao.ObservationRepository;
import org.andou.MCIP.entities.Mention;
import org.andou.MCIP.entities.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MentionMetierImpl implements MentionMetier{
	@Autowired
	private MentionRepository mentionRepository;
	@Autowired
	private ObservationRepository observationRepository;

	@Override
	public PageMention getMentions(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("numeroMention").descending());
		Page<Mention> ops=mentionRepository.findAll(pageable);
		PageMention pOp= new PageMention();
		pOp.setMention(ops.getContent());
		pOp.setNombreOperation(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalPage(ops.getTotalPages());
		pOp.setTotalOperation((int) ops.getTotalElements());
		return pOp;
	}

	@Override
	public Mention saveMention(Mention mention) {
		// TODO Auto-generated method stub
		mention.setDateMention(new Date());
		mention.setHeureMention(new Date());
		return mentionRepository.save(mention);
	}

	@Override
	public Mention infosMention(Long numeroMention) {
		// TODO Auto-generated method stub
		return mentionRepository.findByNumeroMention(numeroMention);
	}

	@Override
	public List<Mention> mentionParDate(Date dateMention) {
		// TODO Auto-generated method stub
		return mentionRepository.findByDateMention(dateMention);
	}

	@Override
	public void faireObservation(long numeroMention, Observation observation) {
		Observation obs = new Observation();
		obs=observation;
		Mention ment = mentionRepository.findById(numeroMention).get();
		obs.setMention(ment);
		observationRepository.save(obs);

	}

	@Override
	public Observation afficherObservationMention(Long numeroMention) {
		// TODO Auto-generated method stub
		return observationRepository.findObservationForMention(numeroMention);
	}

}
