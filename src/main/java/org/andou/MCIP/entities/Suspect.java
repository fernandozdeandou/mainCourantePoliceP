package org.andou.MCIP.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Data  
@NoArgsConstructor  
@ToString
public class Suspect implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuspect;
    private String nomPrenom;
    private String alias;
    @Column(unique = true)
    private String numeroCni;
    private String nomPere;
    private String nomMere;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String lieuNaissance;
    private String lieuDomicile;
    private String numeroTelephone;
    private String photoProfil;
    private String photoEntiere;
    private String photoFace;
    private String sexe;
    private String profession;
    private String ethnie;
    private String nationalite;
    private String distinctionHonorifique;
    private String antecedentJudiciaire;
    private int nombreEnfant;
    private String position;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Suspect_Events",
            joinColumns = {@JoinColumn(name = "susp_id")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")}
    )
    private Collection<Evenement> evenements;

}
