package org.opencr.projet.monprojet;


import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.SecteurManager;
import org.opencr.projet.monprojet.model.Secteur;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  


@Controller
public class SecteurController{
	//@Autowired
	SecteurManager secteurM;
	
	@RequestMapping(value="/createSecteur")
	public ModelAndView showForm()
	{
		return new ModelAndView("creerSecteur","form", new Secteur());
	}
	
	@RequestMapping(value="/saveSecteur", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("secteur") Secteur secteur)
	{
		secteurM.create(secteur);
		return new ModelAndView("redirect:/listerSecteurs");
	}
	
	@RequestMapping(value="/listerSecteurs")
	public ModelAndView list()
	{
		List<Secteur> secteurs= secteurM.list();
		return new ModelAndView("listerSecteurs","secteurs",secteurs);
	}
	
	@RequestMapping(value="/editSecteur/{id}")
	public ModelAndView edit(@PathVariable Long id)
	{
		Secteur secteur =secteurM.getById(id);
		return new ModelAndView("editerSecteur", "form", secteur);
	}
	
	@RequestMapping(value="/editSaveSecteur", method=RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("secteur") Secteur secteur)
	{
		secteurM.edit(secteur);
		return new ModelAndView("redirect:/listerSecteurs");
	}
	
	@RequestMapping(value="/deleteSecteur/{id}")
	public ModelAndView delete(@PathVariable Long id)
	{
		secteurM.delete(id);
		return new ModelAndView ("redirect:/listerSecteurs");
	}
}