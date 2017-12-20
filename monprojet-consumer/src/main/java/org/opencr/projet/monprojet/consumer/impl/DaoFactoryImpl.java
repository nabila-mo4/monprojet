package org.opencr.projet.monprojet.consumer.impl;

import org.opencr.projet.monprojet.consumer.contract.DaoFactory;
import org.opencr.projet.monprojet.consumer.contract.dao.CommentaireDao;
import org.opencr.projet.monprojet.consumer.contract.dao.LongueurDao;
import org.opencr.projet.monprojet.consumer.contract.dao.SecteurDao;
import org.opencr.projet.monprojet.consumer.contract.dao.SiteDao;
import org.opencr.projet.monprojet.consumer.contract.dao.TopoDao;
import org.opencr.projet.monprojet.consumer.contract.dao.VoieDao;

public class DaoFactoryImpl implements DaoFactory{
	
	 
	    private CommentaireDao commentaireDao;
	    private SiteDao siteDao;
	    private TopoDao topoDao;
	   
	    private LongueurDao longueurDao;
	    private SecteurDao secteurDao;
	    private VoieDao voieDao;
	  
	    @Override
	    public CommentaireDao getCommentaireDao() {
	        return commentaireDao;
	    }

	    @Override
	    public void setCommentaireDao(CommentaireDao pCommentaireDao) {
	        commentaireDao = pCommentaireDao;
	    }

	    @Override
	    public LongueurDao getLongueurDao() {
	        return longueurDao;
	    }

	    @Override
	    public void setLongueurDao(LongueurDao vLongueurDao) {
	        longueurDao = vLongueurDao;
	    }

	    @Override
	    public SecteurDao getSecteurDao() {
	        return secteurDao;
	    }

	    @Override
	    public void setSecteurDao(SecteurDao vSecteurDao) {
	        secteurDao = vSecteurDao;
	    }

	    @Override
	    public SiteDao getSiteDao() {
	        return siteDao;
	    }

	    @Override
	    public void setSiteDao(SiteDao vSiteDao) {
	        siteDao = vSiteDao;
	    }

	    @Override
	    public TopoDao getTopoDao() {
	        return topoDao;
	    }

	    @Override
	    public void setTopoDao(TopoDao vTopoDao) {
	        topoDao = vTopoDao;
	    }

	  

	 

	    @Override
	    public VoieDao getVoieDao() {
	        return voieDao;
	    }

	    @Override
	    public void setVoieDao(VoieDao pVoieDao) {
	        voieDao = pVoieDao;
	    }

}
