package org.opencr.projet.monprojet.business.contract.manager;

import java.util.List;

import org.opencr.projet.monprojet.model.Topo;

public interface TopoManager {
	
	Topo getById(int id);
    
    List<Topo> list();
    void create(Topo topo);
    void edit(Topo topo);
    void delete(int id);

}
