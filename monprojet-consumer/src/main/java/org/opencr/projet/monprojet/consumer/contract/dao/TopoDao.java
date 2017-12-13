package org.opencr.projet.monprojet.consumer.contract.dao;

import org.opencr.projet.monprojet.model.Topo;

public interface TopoDao {
	
	void create(Topo Topo);
    
    void delete(int id);
    
    Topo getById(int id);
   
}
