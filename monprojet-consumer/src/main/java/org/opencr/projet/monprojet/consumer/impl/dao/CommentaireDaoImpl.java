package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;

import javax.inject.Inject;
import javax.inject.Named;

import org.opencr.projet.monprojet.consumer.contract.dao.CommentaireDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.opencr.projet.monprojet.model.Commentaire;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.CommentaireA;
@Named
public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {
	
	@Inject
    private CommentaireA CommentaireA;
	
	@Override
    public void create(Commentaire Commentaire) {

        String vSQL = "INSERT INTO Commentaire (nom, emplacementGeo, type, hauteur) VALUES (?, ?, ?, ?)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", Commentaire.getNom(), Types.VARCHAR);
        vParams.addValue("idCommentaire", Commentaire.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM Commentaire WHERE idCommentaire = ?";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }

   

    @Override
    public Commentaire getById(int id) {

        String vSQL = "SELECT * FROM Commentaire WHERE idCommentaire = ?";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Commentaire Commentaire = vJdbcTemplate.queryForObject(vSQL, vParams, CommentaireA);
            return Commentaire;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }

	
	

}
