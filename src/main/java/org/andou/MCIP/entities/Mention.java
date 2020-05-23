package org.andou.MCIP.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Data  
@NoArgsConstructor  
@AllArgsConstructor
@ToString
public class Mention implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroMention;
    private String titre;
    private String commentaire;
    @Temporal(TemporalType.DATE)
    private Date dateMention;
    
    @Temporal(TemporalType.TIME)
    private Date heureMention;
    
    @ManyToOne
    @JoinColumn(
            name = "IdEvenement")
    private Evenement evenement;
    
    @OneToOne(mappedBy = "mention")
	//@JsonProperty(access=Access.WRITE_ONLY)
    private Observation observation;

}
