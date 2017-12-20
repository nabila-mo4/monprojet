package org.opencr.projet.monprojet.consumer.contract.dao;

import java.util.List;

import org.opencr.projet.monprojet.model.Site;

public interface SiteDao {
	
	void create(Site site);
    
    void delete(int id);
    
    Site getById(int id);
    
    List<Site> list();
    
    void update(Site site);
   
}


