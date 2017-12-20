package org.opencr.projet.monprojet.business.contract.manager;

import java.util.List;

import org.opencr.projet.monprojet.model.Commentaire;

public interface CommentaireManager {
	
	Commentaire getById(int id);
	
    void create(Commentaire commentaire);
    void edit(Commentaire commentaire);
    void delete(int id);

}
