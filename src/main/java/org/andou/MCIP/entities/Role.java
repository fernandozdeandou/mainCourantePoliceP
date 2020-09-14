 package org.andou.MCIP.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data  
@NoArgsConstructor  
@AllArgsConstructor
@Table(name = "roles")
public class Role implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	@Column(length = 20)
	private ERole name;
}
