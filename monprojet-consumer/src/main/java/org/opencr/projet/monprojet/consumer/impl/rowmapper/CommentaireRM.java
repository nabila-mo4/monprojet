package org.opencr.projet.monprojet.consumer.impl.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.opencr.projet.monprojet.model.Commentaire;
import org.springframework.jdbc.core.RowMapper;

public class CommentaireRM implements RowMapper<Commentaire> {

    @Override
    public Commentaire mapRow(ResultSet rs, int i) throws SQLException {

        Commentaire commentaire = new Commentaire();

        commentaire.setId(rs.getLong("id"));
        commentaire.setNomUtilisateur(rs.getString("nomUtilisateur"));
        commentaire.setContenu(rs.getString("contenu"));
        commentaire.setDatePublication(rs.getDate("datePublication"));
        commentaire.getSite().setId(rs.getLong("idSite"));
        commentaire.getSecteur().setId(rs.getLong("idSecteur"));
        commentaire.getVoie().setId(rs.getLong("idVoie"));
        commentaire.getLongueur().setId(rs.getLong("idLongueur"));
        commentaire.getTopo().setId(rs.getLong("idTopo"));

        return commentaire;
    }
}