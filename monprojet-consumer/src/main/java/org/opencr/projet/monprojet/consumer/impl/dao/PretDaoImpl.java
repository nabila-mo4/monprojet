package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;

import javax.inject.Inject;

import org.opencr.projet.monprojet.consumer.contract.dao.PretDao;
import org.opencr.projet.monprojet.model.Pret;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.PretA;
@Named
public class PretDaoImpl extends AbstractDaoImpl implements PretDao {
	
	@Inject
    private PretA PretA;
	
	@Override
    public void create(Pret Pret) {

        String vSQL = "INSERT INTO Pret (idTopo, dateDebut, dateFin, nomEmprunteur, emailEmprunteur, nomDemandeur, emailDemandeur) VALUES (?, ?, ?, ?, ?, ?, ?)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", Pret.getNom(), Types.VARCHAR);
        vParams.addValue("idPret", Pret.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM Pret WHERE idPret = ?";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }

   

    @Override
    public Pret getById(int id) {

        String vSQL = "SELECT * FROM Pret WHERE idPret = ?";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Pret Pret = vJdbcTemplate.queryForObject(vSQL, vParams, PretA);
            return Pret;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }


}
