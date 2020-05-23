package org.andou.MCIP.Metier;

import java.util.Date;
import java.util.List;

import org.andou.MCIP.entities.Mention;
import org.andou.MCIP.entities.Observation;

public interface MentionMetier {
	public PageMention getMentions(int page, int size);
	public Mention saveMention(Mention mention);
	public Mention infosMention(Long numeroMention);
	public List<Mention> mentionParDate(Date dateMention);
	public void faireObservation(long numeroMention, Observation observation);
	public Observation afficherObservationMention(Long numeroMention);
}
