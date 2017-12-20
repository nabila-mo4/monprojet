package org.opencr.projet.monprojet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.opencr.projet.monprojet.model.Secteur;
import org.springframework.jdbc.core.RowMapper;

public class SecteurRM implements RowMapper<Secteur> {

    @Override
    public Secteur mapRow(ResultSet rs, int i) throws SQLException {

        Secteur secteur = new Secteur();

        secteur.setId(rs.getLong("id"));
        secteur.setNom(rs.getString("nom"));
        secteur.setHauteur(rs.getInt("hauteur"));
        secteur.getSite().setId(rs.getLong("idSite"));

        return secteur;

    }

	
}