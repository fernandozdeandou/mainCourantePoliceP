package org.andou.MCIP.dao;

import java.util.List;

import org.andou.MCIP.entities.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface SuspectRepository extends JpaRepository<Suspect, Long>{
	public Suspect findByIdSuspect(Long idSuspect);
	public List<Suspect> findByNomPrenomContains(String mc);
	public Suspect findByNumeroCni(String numeroCni);
	
	@Query("select s from Suspect s where s.position='GARDER A VUE'")
	public List<Suspect> suspectGarderAvue();
	
	@Query("select s from Suspect s where s.position='EN FUITE'")
	public List<Suspect> suspectRechercher();  
	
	@Query("select s from Suspect s where s.position='DEFERER'")
	public List<Suspect> suspectDeferer();  
	
}
