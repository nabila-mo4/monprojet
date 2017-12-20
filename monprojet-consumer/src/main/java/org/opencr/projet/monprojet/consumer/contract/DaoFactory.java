package org.opencr.projet.monprojet.consumer.contract;

import org.opencr.projet.monprojet.consumer.contract.dao.CommentaireDao;
import org.opencr.projet.monprojet.consumer.contract.dao.LongueurDao;
import org.opencr.projet.monprojet.consumer.contract.dao.SecteurDao;
import org.opencr.projet.monprojet.consumer.contract.dao.SiteDao;
import org.opencr.projet.monprojet.consumer.contract.dao.TopoDao;
import org.opencr.projet.monprojet.consumer.contract.dao.VoieDao;

public interface DaoFactory {
	
	 

	    CommentaireDao getCommentaireDao();
	    void setCommentaireDao(CommentaireDao pCommentaireDao);

	    LongueurDao getLongueurDao();
	    void setLongueurDao(LongueurDao vLongueurDao);

	    SecteurDao getSecteurDao();
	    void setSecteurDao(SecteurDao vSecteurDao);

	    SiteDao getSiteDao();
	    void setSiteDao(SiteDao vSiteDao);

	    TopoDao getTopoDao();
	    void setTopoDao(TopoDao vTopoDao);
	    
	    VoieDao getVoieDao();
	    void setVoieDao(VoieDao pVoieDao);

}
