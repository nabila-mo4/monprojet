package org.opencr.projet.monprojet.consumer.contract.dao;

import java.util.List;

import org.opencr.projet.monprojet.model.Secteur;

public interface SecteurDao {
	
	void create(Secteur Secteur);
    
    void delete(int id);
    
    Secteur getById(int id);
    
    void update(Secteur secteur);
    List<Secteur> list();
   
}

