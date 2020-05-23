package org.andou.MCIP.Metier;

import java.util.Date;
import java.util.List;

import org.andou.MCIP.entities.Evenement;
import org.andou.MCIP.entities.FormEvent;
import org.andou.MCIP.entities.Requrent;
import org.springframework.data.domain.Page;

public interface EvenementMetier {
	public Evenement saveEvenement(FormEvent eve);
	public Page<Evenement> listeEvenement(int page, int size);
	public Evenement infosEvenement(Long idEvenement);
	public List<Evenement> listerEvenementParDate(Date date);

}
