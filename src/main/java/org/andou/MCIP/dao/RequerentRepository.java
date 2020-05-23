package org.andou.MCIP.dao;

import org.andou.MCIP.entities.Mention;
import org.andou.MCIP.entities.Requrent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface RequerentRepository extends JpaRepository<Requrent, Long>{
	//public Page<Requrent> findAll(PageRequest pageable); 
	public Requrent findByIdRequerent(Long idRequerent);
    
}
