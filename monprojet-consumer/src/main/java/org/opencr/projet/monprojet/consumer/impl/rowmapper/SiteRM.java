package org.opencr.projet.monprojet.consumer.impl.rowmapper;

import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.opencr.projet.monprojet.model.Site;

public class SiteRM implements RowMapper<Site>{

    
    public Site mapRow(ResultSet rs, int i) throws SQLException {

        Site site = new Site();

        site.setId(rs.getLong("id"));
        site.setNom(rs.getString("nom"));
        site.setEmplacementGeo(rs.getString("emplacementGeo"));
        site.setHauteur(rs.getInt("hauteur"));
        site.setType(rs.getString("type"));

        return site;
    }
}