package org.opencr.projet.monprojet.business.contract.manager;

import java.util.List;

import org.opencr.projet.monprojet.model.Longueur;

public interface LongueurManager {
	
	Longueur getById(int id);
    List<Longueur> list();
    void create(Longueur longueur);
    void edit(Longueur longueur);
    void delete(int id);

}
