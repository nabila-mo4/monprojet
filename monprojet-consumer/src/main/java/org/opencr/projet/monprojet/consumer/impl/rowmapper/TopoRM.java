package org.opencr.projet.monprojet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.opencr.projet.monprojet.model.Topo;
import org.springframework.jdbc.core.RowMapper;

public class TopoRM implements RowMapper<Topo> {

    @Override
    public Topo mapRow(ResultSet rs, int i) throws SQLException {

        Topo topo = new Topo();

        topo.setId(rs.getLong("id"));
        topo.setNom(rs.getString("nom"));
        topo.setNomAuteur(rs.getString("nomAuteur"));
        topo.setDateSortie (rs.getString("dateSortie"));
        

        return topo;

    }
}