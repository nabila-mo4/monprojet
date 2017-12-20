package org.opencr.projet.monprojet.business.impl.manager;

import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.LongueurManager;
import org.opencr.projet.monprojet.model.Longueur;

public class LongueurManagerImpl extends AbstractManagerImpl implements LongueurManager {

	@Override
	public Longueur getById(int id) {
		return getDaoFactory().getLongueurDao().getById(id);
	}
	@Override
	public List<Longueur> list() {
		return getDaoFactory().getLongueurDao().list();
	}

	@Override
	public void create(Longueur longueur) {
		getDaoFactory().getLongueurDao().create(longueur);
		
		
	}

	@Override
	public void edit(Longueur longueur) {
		getDaoFactory().getLongueurDao().update(longueur);
		
	}

	@Override
	public void delete(int id) {
		getDaoFactory().getLongueurDao().delete(id);
		
	}
	

}
