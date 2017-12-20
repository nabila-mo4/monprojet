package org.opencr.projet.monprojet.consumer.contract.dao;

import java.util.List;

import org.opencr.projet.monprojet.model.Voie;

public interface VoieDao {
	
	void create(Voie Voie);
    
    void delete(int id);
    
    Voie getById(int id);
   
    void update (Voie voie);
    List<Voie> list();
}
