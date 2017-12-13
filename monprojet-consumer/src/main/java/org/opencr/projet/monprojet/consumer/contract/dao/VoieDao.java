package org.opencr.projet.monprojet.consumer.contract.dao;

import org.opencr.projet.monprojet.model.Voie;

public interface VoieDao {
	
	void create(Voie Voie);
    
    void delete(int id);
    
    Voie getById(int id);
   
}
