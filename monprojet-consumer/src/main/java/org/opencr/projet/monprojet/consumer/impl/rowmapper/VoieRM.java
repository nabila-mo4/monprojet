package org.opencr.projet.monprojet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.opencr.projet.monprojet.model.Voie;
import org.springframework.jdbc.core.RowMapper;

public class VoieRM implements RowMapper<Voie> {
    @Override
    public Voie mapRow(ResultSet rs, int i) throws SQLException {

        Voie voie = new Voie();

        voie.setId(rs.getLong("id"));
        voie.setNom(rs.getString("nom"));
        voie.setNomHauteurVoie(rs.getString("nomHauteurVoie"));
        voie.setHauteur(rs.getInt("hauteur"));
        voie.setEtat(rs.getString("etat"));
        voie.setNbPoints(rs.getInt("nbPoints"));
        voie.getSecteur().setId(rs.getLong("idSecteur"));

        return voie;
    }
}