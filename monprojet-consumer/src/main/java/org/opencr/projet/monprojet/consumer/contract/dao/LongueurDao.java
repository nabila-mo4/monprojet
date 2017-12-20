package org.opencr.projet.monprojet.consumer.contract.dao;

import java.util.List;

import org.opencr.projet.monprojet.model.Longueur;

public interface LongueurDao {
	
	void create(Longueur Longueur);
    
    void delete(int id);
    
    Longueur getById(int id);
    
    void update(Longueur longueur);
    List<Longueur> list ();
   
}


