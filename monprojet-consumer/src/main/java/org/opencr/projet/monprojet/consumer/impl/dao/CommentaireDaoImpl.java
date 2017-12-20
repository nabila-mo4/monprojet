package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.opencr.projet.monprojet.consumer.contract.dao.CommentaireDao;
import org.opencr.projet.monprojet.model.Secteur;
import org.opencr.projet.monprojet.model.Site;
import org.opencr.projet.monprojet.model.Commentaire;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.CommentaireA;
import org.opencr.projet.monprojet.consumer.impl.rowmapper.CommentaireRM;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;



@Named
public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {
	
	@Inject
    private CommentaireRM commentaireRM;
	
	@Override
    public void create(Commentaire commentaire) {
		

        String vSQL = "INSERT INTO public.Commentaire (datePublication, nomUtilisateur, contenu, idSite, idSecteur, idVoie, idLongueur, idTopo) VALUES (:datePublication,:nomUtilisateur,:contenu, :idSite, :idSecteur, :idVoie, :idLongueur, :idTopo )";
      
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("datePublication", commentaire.getDatePublication(), Types.VARCHAR);
        vParams.addValue("nomUtilisateur", commentaire.getNomUtilisateur(), Types.VARCHAR);
        vParams.addValue("contenu", commentaire.getContenu(), Types.VARCHAR);
        vParams.addValue("idSite", commentaire.getSite().getId(), Types.INTEGER);
        vParams.addValue("idSecteur", commentaire.getSecteur().getId(), Types.INTEGER);
        vParams.addValue("idVoie", commentaire.getVoie().getId(), Types.INTEGER);
        vParams.addValue("idLongueur", commentaire.getLongueur().getId(), Types.INTEGER);
        vParams.addValue("idTopo", commentaire.getTopo().getId(), Types.INTEGER);
        
        
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM public.Commentaire WHERE idCommentaire = :id";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }
    
    

   

    @Override
    public Commentaire getById(int id) {

        String vSQL = "SELECT * FROM public.Commentaire WHERE idCommentaire = :id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Commentaire commentaire = vJdbcTemplate.queryForObject(vSQL, vParams, commentaireRM);
            return commentaire;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }
    
   
    public List<Commentaire> list() {

        String vSQL = "SELECT * FROM public.Commentaire";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        List<Commentaire> vListCommentaire = vJdbcTemplate.query(vSQL,commentaireRM);
        return vListCommentaire;

    }
	
	
	public void update(Commentaire commentaire) {

        String vSQL = "UPDATE public.Commentaire " +
                "SET datePublication=:datePublication, nomUtilisateur=:nomUtilisateur, contenu=:contenu, idSite=:idSite, idSecteur=:idSecteur, idVoie=:idVoie, idLongueur=:idLongueur, idTopo=:idTopo " +
        		
                "WHERE idCommentaire=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", commentaire.getId(), Types.INTEGER);
        vParams.addValue("datePublication", commentaire.getDatePublication(), Types.VARCHAR);
        vParams.addValue("nomUtilisateur", commentaire.getNomUtilisateur(), Types.VARCHAR);
        vParams.addValue("contenu", commentaire.getContenu(), Types.VARCHAR);
        vParams.addValue("idSite", commentaire.getSite().getId(), Types.INTEGER);
        vParams.addValue("idSecteur", commentaire.getSecteur().getId(), Types.INTEGER);
        vParams.addValue("idVoie", commentaire.getVoie().getId(), Types.INTEGER);
        vParams.addValue("idLongueur", commentaire.getLongueur().getId(), Types.INTEGER);
        vParams.addValue("idTopo", commentaire.getTopo().getId(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }
	

	

   
}


