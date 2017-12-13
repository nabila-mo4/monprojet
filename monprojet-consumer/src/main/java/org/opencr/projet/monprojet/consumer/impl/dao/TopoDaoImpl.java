package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;

import javax.inject.Inject;
import javax.inject.Named;
import org.opencr.projet.monprojet.model.Topo;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.TopoA;


import org.opencr.projet.monprojet.consumer.contract.dao.TopoDao;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Named

public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao{
	
	@Inject
    private SiteA siteA;
	
	@Override
    public void create(Site site) {

        String vSQL = "INSERT INTO Pret (idTopo, dateDebut, dateFin, nomEmprunteur, emailEmprunteur, nomDemandeur, emailDemandeur) VALUES (?, ?, ?, ?, ?, ?, ?)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", site.getNom(), Types.VARCHAR);
        vParams.addValue("idSite", site.getId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM Site WHERE idSite = ?";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }

   

    @Override
    public Site getById(int id) {

        String vSQL = "SELECT * FROM Site WHERE idSite = ?";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Site site = vJdbcTemplate.queryForObject(vSQL, vParams, siteA);
            return site;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }

}
