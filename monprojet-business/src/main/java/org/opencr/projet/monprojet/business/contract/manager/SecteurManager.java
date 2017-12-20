package org.opencr.projet.monprojet.business.contract.manager;

import java.util.List;

import org.opencr.projet.monprojet.model.Secteur;

public interface SecteurManager {
	
	Secteur getById(int id);
    List<Secteur> list();
    void create(Secteur secteur);
    void edit(Secteur secteur);
    void delete(int id);
    

}
