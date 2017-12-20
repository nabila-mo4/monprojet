package org.opencr.projet.monprojet.business.impl.manager;

import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.SecteurManager;
import org.opencr.projet.monprojet.model.Secteur;

public class SecteurManagerImpl extends AbstractManagerImpl implements SecteurManager {

	
	public Secteur getById(int id) {
		return getDaoFactory().getSecteurDao().getById(id);
	}


	public List<Secteur> list() {
		return getDaoFactory().getSecteurDao().list();
	}


	public void create(Secteur secteur) {
		getDaoFactory().getSecteurDao().create(secteur);		
	}

	
	public void edit(Secteur secteur) {
		getDaoFactory().getSecteurDao().update(secteur);
		
	}

	
	public void delete(int id) {
		getDaoFactory().getSecteurDao().delete(id);
		
	}

}
