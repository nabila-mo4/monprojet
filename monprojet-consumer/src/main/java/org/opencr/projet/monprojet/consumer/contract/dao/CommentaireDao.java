package org.opencr.projet.monprojet.consumer.contract.dao;

import org.opencr.projet.monprojet.model.Commentaire;

public interface CommentaireDao {
	
	void create(Commentaire Commentaire);
    
    void delete(int id);
    
    Commentaire getById(int id);
   
}
