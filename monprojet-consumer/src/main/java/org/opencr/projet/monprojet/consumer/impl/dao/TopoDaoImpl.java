package org.opencr.projet.monprojet.consumer.impl.dao;

import java.sql.Types;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.opencr.projet.monprojet.consumer.contract.dao.TopoDao;
import org.opencr.projet.monprojet.model.Secteur;
import org.opencr.projet.monprojet.model.Topo;
import org.opencr.projet.monprojet.consumer.impl.RowMapper.TopoA;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;



@Named
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {
	
	@Inject
    private TopoRM topoRM;
	
	@Override
    public void create(Topo topo) {
		

        String vSQL = "INSERT INTO public.Topo (nom, nomAuteur,dateSortie) VALUES (:nom,:nomAuteur,:dateSortie)";
      
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", topo.getNom(), Types.VARCHAR);
        vParams.addValue("nomAuteur", topo.getNomAuteur(), Types.VARCHAR);
        vParams.addValue("dateSortie", topo.getDateSortie(), Types.VARCHAR);
       
        
        
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void delete(int id) {

        String vSQL = "DELETE FROM public.Topo WHERE idTopo = :id";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", id, Types.INTEGER);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }
    
    

   

    @Override
    public Topo getById(int id) {

        String vSQL = "SELECT * FROM public.Topo WHERE idTopo = :id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Topo topo = vJdbcTemplate.queryForObject(vSQL, vParams, topoRM);
            return topo;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }


    }
    
   
    public List<Topo> list() {

        String vSQL = "SELECT * FROM public.Topo";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        List<Topo> vListTopo = vJdbcTemplate.query(vSQL,topoRM);
        return vListTopo;

    }
	
	
	public void update(Topo topo) {

        String vSQL = "UPDATE public.Topo " +
                "SET nom=:nom, nomAuteur=:nomAuteur, dateSortie=:dateSortie " +
        		
                "WHERE idTopo=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", topo.getId(), Types.INTEGER);
        vParams.addValue("nom", topo.getNom(), Types.VARCHAR);
        vParams.addValue("nomAuteur", topo.getNomAuteur(), Types.VARCHAR);
        vParams.addValue("dateSortie", topo.getDateSortie(), Types.VARCHAR);
       
       
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }

   
}


