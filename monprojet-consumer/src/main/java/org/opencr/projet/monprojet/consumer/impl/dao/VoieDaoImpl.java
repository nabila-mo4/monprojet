package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.opencr.projet.monprojet.consumer.contract.dao.VoieDao;
import org.opencr.projet.monprojet.model.Secteur;
import org.opencr.projet.monprojet.model.Voie;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.VoieA;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;



@Named
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {
	
	@Inject
    private VoieRM voieRM;
	
	@Override
    public void create(Voie voie) {
		

        String vSQL = "INSERT INTO public.Voie (nom, nomHauteurVoie, hauteur, nbPoints, etat, idSecteur) VALUES (:nom,:nomHauteurVoie,:hauteur, :nbPoints, :etat, :idSecteur)";
      
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", voie.getNom(), Types.VARCHAR);
        vParams.addValue("nomHauteurVoie", voie.getNomHauteurVoie(), Types.VARCHAR);
        vParams.addValue("hauteur", voie.getHauteur(), Types.INTEGER);
        vParams.addValue("nbPoints", voie.getNbPoints(), Types.INTEGER);
        vParams.addValue("etat", voie.getEtat(), Types.VARCHAR);
        vParams.addValue("idSecteur", voie.getSecteur().getId(), Types.INTEGER);
       
        
        
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM public.Voie WHERE idVoie = :id";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }
    
    

   

    @Override
    public Voie getById(int id) {

        String vSQL = "SELECT * FROM public.Voie WHERE idVoie = :id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Voie voie = vJdbcTemplate.queryForObject(vSQL, vParams, voieRM);
            return voie;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }
    
   
    public List<Voie> list() {

        String vSQL = "SELECT * FROM public.Voie";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        List<Voie> vListVoie = vJdbcTemplate.query(vSQL,voieRM);
        return vListVoie;

    }
	
	
	public void update(Voie voie) {

        String vSQL = "UPDATE public.Voie " +
                "SET nom=:nom, nomHauteurVoie=:nomHauteurVoie, hauteur=:hauteur, nbPoints=:nbPoints, etat=:etat, idSecteur=:idSecteur " +
        		
                "WHERE idVoie=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", voie.getId(), Types.INTEGER);
        vParams.addValue("nom", voie.getNom(), Types.VARCHAR);
        vParams.addValue("nomHauteurVoie", voie.getNomHauteurVoie(), Types.VARCHAR);
        vParams.addValue("hauteur", voie.getHauteur(), Types.INTEGER);
        vParams.addValue("nbPoints", voie.getNbPoints(), Types.INTEGER);
        vParams.addValue("etat", voie.getEtat(), Types.VARCHAR);
        vParams.addValue("idSecteur", voie.getSecteur().getId(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }

   
}


