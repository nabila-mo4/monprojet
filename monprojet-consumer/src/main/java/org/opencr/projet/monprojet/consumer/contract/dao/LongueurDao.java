package org.opencr.projet.monprojet.consumer.contract.dao;

import org.opencr.projet.monprojet.model.Longueur;

public interface LongueurDao {
	
	void create(Longueur Longueur);
    
    void delete(int id);
    
    Longueur getById(int id);
   
}
