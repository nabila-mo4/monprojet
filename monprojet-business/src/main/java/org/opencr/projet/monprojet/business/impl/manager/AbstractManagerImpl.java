package org.opencr.projet.monprojet.business.impl.manager;

import org.opencr.projet.monprojet.consumer.contract.DaoFactory;

public abstract class AbstractManagerImpl {
	
	private DaoFactory daoFactory;

	protected DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	

}
