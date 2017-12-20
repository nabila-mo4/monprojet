package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.opencr.projet.monprojet.consumer.contract.dao.SiteDao;
import org.opencr.projet.monprojet.model.Secteur;
import org.opencr.projet.monprojet.model.Site;
import org.opencr.projet.monprojet.consumer.impl.rowmapper.SiteRM;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;



@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	
	@Inject
    private SiteRM siteRM;
	
	@Override
    public void create(Site site) {
		

        String vSQL = "INSERT INTO public.Site (nom, emplacementGeo, hauteur, type) VALUES (:nom,:emplacementGeo,:hauteur, :type)";
      
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", site.getNom(), Types.VARCHAR);
        vParams.addValue("emplacementGeo", site.getEmplacementGeo(), Types.VARCHAR);
        vParams.addValue("hauteur", site.getHauteur(), Types.INTEGER);
        vParams.addValue("type", site.getType(), Types.VARCHAR);
        
        
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM public.Site WHERE idSite = :id";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }
    
    

   

    @Override
    public Site getById(int id) {

        String vSQL = "SELECT * FROM public.Site WHERE idSite = :id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Site site = vJdbcTemplate.queryForObject(vSQL, vParams, siteRM);
            return site;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }
    
   
    public List<Site> list() {

        String vSQL = "SELECT * FROM public.Site";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        List<Site> vListSite = vJdbcTemplate.query(vSQL,siteRM);
        return vListSite;

    }
	
	
	public void update(Site site) {

        String vSQL = "UPDATE public.Site " +
                "SET nom=:nom, emplacementGeo=:emplacementGeo, hauteur=:hauteur, type=:type " +
        		
                "WHERE idSite=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", site.getId(), Types.INTEGER);
        vParams.addValue("nom", site.getNom(), Types.VARCHAR);
        vParams.addValue("emplacementGeo", site.getEmplacementGeo(), Types.VARCHAR);
        vParams.addValue("hauteur", site.getHauteur(), Types.INTEGER);
        vParams.addValue("type", site.getType(), Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }

   
}


