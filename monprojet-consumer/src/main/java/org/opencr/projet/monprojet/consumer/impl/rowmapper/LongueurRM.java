package org.opencr.projet.monprojet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.opencr.projet.monprojet.model.Longueur;
import org.springframework.jdbc.core.RowMapper;

public class LongueurRM implements RowMapper<Longueur> {
    @Override
    public Longueur mapRow(ResultSet rs, int i) throws SQLException {

        Longueur longueur = new Longueur();

        longueur.setId(rs.getLong("id"));
        longueur.setNomRelais(rs.getString("nomRelais"));
        longueur.setHauteur(rs.getInt("hauteur"));
        longueur.setCotation(rs.getString("cotation"));
        longueur.getVoie().setId(rs.getLong("idVoie"));

        return longueur;



    }
}