package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;

import javax.inject.Inject;
import javax.inject.Named;

import org.opencr.projet.monprojet.consumer.contract.dao.SiteDao;
import org.opencr.projet.monprojet.model.Site;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.SiteA;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;



@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	
	@Inject
    private SiteA siteA;
	
	@Override
    public void create(Site site) {

        String vSQL = "INSERT INTO Site (nom, emplacementGeo, type, hauteur) VALUES (?, ?, ?, ?)";

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


