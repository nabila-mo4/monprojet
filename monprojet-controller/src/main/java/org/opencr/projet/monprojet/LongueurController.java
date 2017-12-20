package org.opencr.projet.monprojet;


import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.LongueurManager;
import org.opencr.projet.monprojet.model.Longueur;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  


@Controller
public class LongueurController{
	//@Autowired
	LongueurManager longueurM;
	
	@RequestMapping(value="/createLongueur")
	public ModelAndView showForm()
	{
		return new ModelAndView("creerLongueur","form", new Longueur());
	}
	
	@RequestMapping(value="/saveLongueur", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("longueur") Longueur longueur)
	{
		longueurM.create(longueur);
		return new ModelAndView("redirect:/listerLongueurs");
	}
	
	@RequestMapping(value="/listerLongueurs")
	public ModelAndView list()
	{
		List<Longueur> longueurs= longueurM.list();
		return new ModelAndView("listerLongueurs","longueurs",longueurs);
	}
	
	@RequestMapping(value="/editLongueur/{id}")
	public ModelAndView edit(@PathVariable Long id)
	{
		Longueur longueur =longueurM.getById(id);
		return new ModelAndView("editerLongueur", "form", longueur);
	}
	
	@RequestMapping(value="/editSaveLongueur", method=RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("longueur") Longueur longueur)
	{
		longueurM.edit(longueur);
		return new ModelAndView("redirect:/listerLongueurs");
	}
	
	@RequestMapping(value="/deleteLongueur/{id}")
	public ModelAndView delete(@PathVariable Long id)
	{
		longueurM.delete(id);
		return new ModelAndView ("redirect:/listerLongueurs");
	}
}
