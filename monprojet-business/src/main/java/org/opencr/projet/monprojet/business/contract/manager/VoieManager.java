package org.opencr.projet.monprojet.business.contract.manager;

import java.util.List;

import org.opencr.projet.monprojet.model.Voie;

public interface VoieManager {
	
		Voie getById(int id);
	    List<Voie> list();
	    void create(Voie voie);
	    void edit(Voie voie);
	    void delete(int id);
	    

}