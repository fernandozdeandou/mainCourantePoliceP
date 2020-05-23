package org.andou.MCIP.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FormPerso {
	private String matricule;
    private String nomPrenom;
    private String numero_cni;
    private Date dateNaissance;
    private String lieuDomicile;
    private String numeroTelephone;
    private String sexe;
    private String grade;
    private String fonction;
    private String email;
}
