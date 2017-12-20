package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.opencr.projet.monprojet.consumer.contract.dao.LongueurDao;
import org.opencr.projet.monprojet.model.Secteur;
import org.opencr.projet.monprojet.model.Longueur;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.LongueurA;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;



@Named
public class LongueurDaoImpl extends AbstractDaoImpl implements LongueurDao {
	
	@Inject
    private LongueurRM longueurRM;
	
	@Override
    public void create(Longueur longueur) {
		

        String vSQL = "INSERT INTO public.Longueur (cotation, nomRelais, hauteur, idVoie) VALUES (:cotation,:nomRelais,:hauteur, :idVoie)";
      
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", longueur.getCotation(), Types.VARCHAR);
        vParams.addValue("nomRelais", longueur.getNomRelais(), Types.VARCHAR);
        vParams.addValue("hauteur", longueur.getHauteur(), Types.INTEGER);
        vParams.addValue("idVoie", longueur.getVoie().getId(), Types.INTEGER);
        
        
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM public.Longueur WHERE idLongueur = :id";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }
    
    

   

    @Override
    public Longueur getById(int id) {

        String vSQL = "SELECT * FROM public.Longueur WHERE idLongueur = :id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Longueur longueur = vJdbcTemplate.queryForObject(vSQL, vParams, longueurRM);
            return longueur;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }
    
   
    public List<Longueur> list() {

        String vSQL = "SELECT * FROM public.Longueur";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        List<Longueur> vListLongueur = vJdbcTemplate.query(vSQL,longueurRM);
        return vListLongueur;

    }
	
	
	public void update(Longueur longueur) {

        String vSQL = "UPDATE public.Longueur " +
                "SET cotation=:cotation, nomRelais=:nomRelais, hauteur=:hauteur, idVoie=:idVoie" +
        		
                "WHERE idLongueur=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", longueur.getId(), Types.INTEGER);
        vParams.addValue("nom", longueur.getCotation(), Types.VARCHAR);
        vParams.addValue("nomRelais", longueur.getNomRelais(), Types.VARCHAR);
        vParams.addValue("hauteur", longueur.getHauteur(), Types.INTEGER);
        vParams.addValue("idVoie", longueur.getVoie().getId(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }

   
}


