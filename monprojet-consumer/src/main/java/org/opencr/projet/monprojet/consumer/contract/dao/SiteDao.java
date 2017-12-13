package org.opencr.projet.monprojet.consumer.contract.dao;

import org.opencr.projet.monprojet.model.Site;

public interface SiteDao {
	
	void create(Site site);
    
    void delete(int id);
    
    Site getById(int id);
   
}
