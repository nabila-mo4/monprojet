package org.opencr.projet.monprojet.consumer.contract.dao;

import java.util.List;

import org.opencr.projet.monprojet.model.Topo;

public interface TopoDao {
	
	void create(Topo Topo);
    
    void delete(int id);
    
    Topo getById(int id);
    void update(Topo topo);
    List<Topo> list ();
}

