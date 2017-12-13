package org.opencr.projet.monprojet.consumer.contract.dao;

import org.opencr.projet.monprojet.model.Pret;

public interface PretDao {
	
	void create(Pret Pret);
    
    void delete(int id);
    
    Pret getById(int id);
   
}
