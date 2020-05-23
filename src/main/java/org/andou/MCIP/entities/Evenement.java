package org.andou.MCIP.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Data  
@NoArgsConstructor  
@ToString
@AllArgsConstructor
public class Evenement implements Serializable{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idEvenement;
	    private String nomEvenement;
	    private String saisine;
	    @Temporal(TemporalType.DATE)
	    private Date date;
	    private String heureEvenement;
	    private String lieuEvenement;
	    @ManyToOne
	    @JoinColumn(name="RequerentId")
	    private Requrent requerent;
	    @ManyToOne
	    @JoinColumn(name="PersonnelId")
	    private Personnel enqueteur;
	    @ManyToMany(mappedBy = "evenements", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	    @JsonProperty(access=Access.WRITE_ONLY)
	    private Collection<Suspect> suspects;
	    @OneToMany(mappedBy="evenement")
	    @JsonProperty(access=Access.WRITE_ONLY)
	    private List<Mention> mentions;
}
