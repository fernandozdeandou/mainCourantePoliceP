package org.andou.MCIP.entities;

import java.util.Collection;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FormSusp {
	private String nomPrenom;
    private String alias;
    private String numeroCni;
    private String nomPere;
    private String nomMere;
    private Date dateNaissance;
    private String lieuNaissance;
    private String lieuDomicile;
    private String numeroTelephone;
    private String sexe;
    private String profession;
    private String ethnie;
    private String nationalite;
    private String distinctionHonorifique;
    private int nombreEnfant;
}
