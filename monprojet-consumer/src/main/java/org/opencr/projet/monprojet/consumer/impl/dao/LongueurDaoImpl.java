package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;

import javax.inject.Inject;
import javax.inject.Named;

import org.opencr.projet.monprojet.consumer.contract.dao.LongueurDao;
import org.opencr.projet.monprojet.model.Longueur;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.LongueurA;

@Named
public class LongueurDaoImpl extends AbstractDaoImpl implements LongueurDao{
	
	@Inject
    private LongueurA LongueurA;
	
	@Override
    public void create(Longueur Longueur) {

        String vSQL = "INSERT INTO Longueur (idVoie, hauteur, cotation, nomRelais) VALUES (?, ?, ?, ?)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", Longueur.getNom(), Types.VARCHAR);
        vParams.addValue("idLongueur", Longueur.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM Longueur WHERE idLongueur = ?";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }

   

    @Override
    public Longueur getById(int id) {

        String vSQL = "SELECT * FROM Longueur WHERE idLongueur = ?";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Longueur Longueur = vJdbcTemplate.queryForObject(vSQL, vParams, LongueurA);
            return Longueur;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }

}
