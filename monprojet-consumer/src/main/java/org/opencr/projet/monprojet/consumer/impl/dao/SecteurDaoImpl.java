package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;

import javax.inject.Inject;

import org.opencr.projet.monprojet.consumer.contract.dao.SecteurDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.opencr.projet.monprojet.model.Secteur;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.SecteurA;

public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {
	
	@Inject
    private SecteurA SecteurA;
	
	@Override
    public void create(Secteur Secteur) {

        String vSQL = "INSERT INTO Secteur (idSite, nom, hauteur) VALUES (?, ?, ?)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", Secteur.getNom(), Types.VARCHAR);
        vParams.addValue("idSecteur", Secteur.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM Secteur WHERE idSecteur = ?";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }

   

    @Override
    public Secteur getById(int id) {

        String vSQL = "SELECT * FROM Secteur WHERE idSecteur = ?";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Secteur Secteur = vJdbcTemplate.queryForObject(vSQL, vParams, SecteurA);
            return Secteur;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }

}
