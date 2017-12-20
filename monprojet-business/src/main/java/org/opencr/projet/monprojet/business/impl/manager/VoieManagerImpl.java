package org.opencr.projet.monprojet.business.impl.manager;

import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.VoieManager;
import org.opencr.projet.monprojet.model.Voie;

public class VoieManagerImpl extends AbstractManagerImpl implements VoieManager {

	@Override
	public Voie getById(int id) {
		return getDaoFactory().getVoieDao().getById(id);
	}

	@Override
	public List<Voie> list() {
		return getDaoFactory().getVoieDao().list();
	}

	@Override
	public void create(Voie voie) {
		getDaoFactory().getVoieDao().create(voie);
		
	}

	@Override
	public void edit(Voie voie) {
		getDaoFactory().getVoieDao().update(voie);
	}

	@Override
	public void delete(int id) {
		getDaoFactory().getVoieDao().delete(id);
		
	}

}
