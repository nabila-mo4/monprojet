package org.opencr.projet.monprojet.business.impl.manager;

import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.TopoManager;
import org.opencr.projet.monprojet.model.Topo;

public class TopoManagerImpl extends AbstractManagerImpl implements TopoManager {

	@Override
	public Topo getById(int id) {
		return getDaoFactory().getTopoDao().getById(id);
	}

	@Override
	public List<Topo> list() {
		return getDaoFactory().getTopoDao().list();
	}

	@Override
	public void create(Topo topo) {
		getDaoFactory().getTopoDao().create(topo);
		
	}

	@Override
	public void edit(Topo topo) {
		getDaoFactory().getTopoDao().update(topo);
		
	}

	@Override
	public void delete(int id) {
		getDaoFactory().getTopoDao().delete(id);
		
	}

}
