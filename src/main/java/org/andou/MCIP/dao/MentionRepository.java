package org.andou.MCIP.dao;

import java.util.Date;
import java.util.List;


import org.andou.MCIP.entities.Mention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface MentionRepository extends JpaRepository<Mention, Long>{
	public List<Mention> findByDateMention(Date dateMention);
	public Mention findByNumeroMention(Long numeroMention);
	
	Boolean existsByNumeroMention(Long numeroMention);  
}
