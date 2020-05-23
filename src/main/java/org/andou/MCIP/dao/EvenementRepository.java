package org.andou.MCIP.dao;

import java.util.Date;
import java.util.List;

import org.andou.MCIP.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface EvenementRepository extends JpaRepository<Evenement, Long>{
	public List<Evenement> findByDate(Date date);
	public Evenement findByIdEvenement(Long idEvenement);
    
}
