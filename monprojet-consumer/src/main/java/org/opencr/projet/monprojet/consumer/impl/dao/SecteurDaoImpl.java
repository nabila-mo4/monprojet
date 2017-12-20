package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.opencr.projet.monprojet.consumer.contract.dao.SecteurDao;
import org.opencr.projet.monprojet.consumer.contract.dao.SecteurDao;
import org.opencr.projet.monprojet.model.Secteur;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.SecteurA;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;



@Named
public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {
	
	@Inject
    private SecteurRM secteurRM;
	
	@Override
    public void create(Secteur secteur) {
		

        String vSQL = "INSERT INTO public.Secteur (hauteur, nom, idSite ) VALUES (:hauteur,:nom,:idSite)";
      
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("hauteur", secteur.getHauteur(), Types.INTEGER);
        vParams.addValue("nom", secteur.getNom(), Types.VARCHAR);
        vParams.addValue("idSite", secteur.getSite().getId(), Types.INTEGER);
       
        
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM public.Secteur WHERE idSecteur = :id";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }
    
    

   

    @Override
    public Secteur getById(int id) {

        String vSQL = "SELECT * FROM public.Secteur WHERE idSecteur = :id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Secteur secteur = vJdbcTemplate.queryForObject(vSQL, vParams, secteurRM);
            return secteur;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }
    
   
	
	
	public List<Secteur> list() {

        String vSQL = "SELECT * FROM public.Secteur";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL,secteurRM);
        return vListSecteur;

    }
	
	
	public void update(Secteur secteur) {

        String vSQL = "UPDATE public.Secteur " +
                "SET hauteur=:hauteur, nom=:nom, idSite=:idSite " +
        		
                "WHERE idSecteur=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", secteur.getId(), Types.INTEGER);
        vParams.addValue("hauteur", secteur.getHauteur(), Types.INTEGER);
        vParams.addValue("nom", secteur.getNom(), Types.VARCHAR);
        vParams.addValue("idSite", secteur.getSite().getId(), Types.INTEGER);
        

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }

   
}


