package org.andou.MCIP.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class FormEvent {
	private String nomEvenement;
    private String saisine;
    private Date date;
    private String heureEvenement;
    private String lieuEvenement;
   // private Requrent requerent;
    private Long idREquerent;
   // private Personnel enqueteur;
    private String matriEnqueteur;
    //private Collection<Suspect> suspects;
    

}
