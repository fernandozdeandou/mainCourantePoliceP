package org.andou.MCIP.dao;







import org.andou.MCIP.entities.Personnel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@RepositoryRestResource
public interface PersonnelRepository extends JpaRepository<Personnel, String>{
	public Personnel findByMatricule(String matricule);
	
	// public Page<Personnel> listPersonnelParPage(PageRequest pageable);
	
	@Query("select p from Personnel p where p.statut='MALADE'")
	public Page<Personnel> personnelMalade(PageRequest pageable); 
	
	@Query("select p from Personnel p where p.statut='PERMISSIONNAIRE'")
	public Page<Personnel> personnelPermissionnaire(PageRequest pageable);
	
	@Query("select p from Personnel p where p.statut='EN SERVICE'")
	public Page<Personnel> personnelOperationnel(PageRequest pageable);
	
	@Query("select p from Personnel p where p.statut='EN CONGE'")
	public Page<Personnel> personnelConge(PageRequest pageable);	
	 
	@Query("select p from Personnel p where p.statut='AFFECTE'")
	public Page<Personnel> personnelAffecte(PageRequest pageable);	
	 
}
