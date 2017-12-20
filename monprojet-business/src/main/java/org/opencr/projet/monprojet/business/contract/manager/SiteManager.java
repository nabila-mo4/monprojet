package org.opencr.projet.monprojet.business.contract.manager;

import java.util.List;


import org.opencr.projet.monprojet.model.Site;

public interface SiteManager {
	
		Site getById(int id);
		List<Site> list();
	    void create(Site site);
	    void edit(Site site);
	    void delete(int id);
	    

}
