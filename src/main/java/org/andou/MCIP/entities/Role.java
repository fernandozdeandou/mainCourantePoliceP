 package org.andou.MCIP.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Data  
@NoArgsConstructor  
@ToString
public class Role implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_role;
    private String roleName;
    @OneToMany(mappedBy="roles")
    @JsonProperty(access=Access.WRITE_ONLY)
    private Collection<Personnel> personnels;

}
