package org.andou.MCIP.dao;

import org.andou.MCIP.entities.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
	
	
	/*@Query("SELECT u FROM User u WHERE u.status = :status and u.name = :name")
	User findUserByStatusAndNameNamedParams(
	  @Param("status") Integer status,
	  @Param("name") String name);*/
	
	@Query("SELECT o FROM Observation o WHERE o.mention.numeroMention =:id")
	Observation findObservationForMention( @Param("id")Long id);

}
