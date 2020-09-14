package org.andou.MCIP.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Data  
@NoArgsConstructor  
@ToString
@AllArgsConstructor
public class Personnel implements Serializable{
	@Id
    @Column(length=15)
    private String matricule;
    @Column(length=70)
    private String nomPrenom;
    @Column(unique = true,length=30)
    private String numero_cni;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(length=30)
    private String lieuDomicile;
    @Column(length=20)
    private String numeroTelephone;
    private String photoProfil;
    private String sexe;
    private String grade;
    @Column(length=50)
    private String fonction;
    @Temporal(TemporalType.DATE)
    private Date datePriseService;
    @Temporal(TemporalType.DATE)
    private Date dateAffectation;
    private String statut;
    @Column(name = "email", unique = true)
	private String email;
}
