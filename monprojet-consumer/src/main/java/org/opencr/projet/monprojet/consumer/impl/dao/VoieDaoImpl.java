package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;

import javax.inject.Inject;

import org.opencr.projet.monprojet.consumer.contract.dao.VoieDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.opencr.projet.monprojet.model.Voie;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.VoieA;


public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {
	
	@Inject
    private VoieA VoieA;
	
	@Override
    public void create(Voie Voie) {

        String vSQL = "INSERT INTO Voie (idSecteur, nom, hauteur, nomHauteurVoie, etat, nbPoints) VALUES (?, ?, ?, ?, ?, ?)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", Voie.getNom(), Types.VARCHAR);
        vParams.addValue("idVoie", Voie.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM Voie WHERE idVoie = ?";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }

   

    @Override
    public Voie getById(int id) {

        String vSQL = "SELECT * FROM Voie WHERE idVoie = ?";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Voie Voie = vJdbcTemplate.queryForObject(vSQL, vParams, VoieA);
            return Voie;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }

   

}
