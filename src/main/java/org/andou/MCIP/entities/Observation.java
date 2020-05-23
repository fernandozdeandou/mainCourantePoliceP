package org.andou.MCIP.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Data  
@NoArgsConstructor  
@ToString
public class Observation implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idObservation;
	private String message;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "mention_id", referencedColumnName = "numeroMention")
	@JsonProperty(access=Access.WRITE_ONLY)
    private Mention mention;
}
