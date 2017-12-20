package org.opencr.projet.monprojet.business.impl.manager;


import java.util.List;

import javax.inject.Named;

import org.opencr.projet.monprojet.business.contract.manager.SiteManager;
import org.opencr.projet.monprojet.model.Site;

@Named
public class SiteManagerImpl extends AbstractManagerImpl implements SiteManager {

	
	
	public void create(Site site) {
		getDaoFactory().getSiteDao().create(site);	
	}

	
	public List<Site> list() {
		return getDaoFactory().getSiteDao().list();
	}

	
	public void edit(Site site) {
		
		 getDaoFactory().getSiteDao().update(site);
	}

	
	public Site getById(int id) {
		
		return getDaoFactory().getSiteDao().getById(id);
	}

	
	public void delete(int id) {
		getDaoFactory().getSiteDao().delete(id);
		
	}
	
	

}
