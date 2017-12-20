package org.opencr.projet.monprojet.business.impl.manager;

import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.CommentaireManager;
import org.opencr.projet.monprojet.model.Commentaire;

public class CommentaireManagerImpl extends AbstractManagerImpl implements CommentaireManager{

	@Override
	public Commentaire getById(int id) {
		return getDaoFactory().getCommentaireDao().getById(id);
	}

	

	@Override
	public void create(Commentaire commentaire) {
		getDaoFactory().getCommentaireDao().create(commentaire);
		
	}

	@Override
	public void edit(Commentaire commentaire) {
		getDaoFactory().getCommentaireDao().update(commentaire);
	}

	@Override
	public void delete(int id) {
		getDaoFactory().getCommentaireDao().delete(id);
		
	}

}
