package org.opencr.projet.monprojet.consumer.contract.dao;

import org.opencr.projet.monprojet.model.Secteur;

public interface SecteurDao {
	
	void create(Secteur Secteur);
    
    void delete(int id);
    
    Secteur getById(int id);
   
}
