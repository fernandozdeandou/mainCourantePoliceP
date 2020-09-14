package org.andou.MCIP.dao;

import java.util.List;
import java.util.Optional;

import org.andou.MCIP.entities.Observation;
import org.andou.MCIP.entities.Suspect;
import org.andou.MCIP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.username =:matricule")
	User findUserparMatricule( @Param("matricule")String matricule);
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
}
