package org.opencr.projet.monprojet;


import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.VoieManager;
import org.opencr.projet.monprojet.model.Voie;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  


@Controller
public class VoieController{
	//@Autowired
	VoieManager voieM;
	
	@RequestMapping(value="/createVoie")
	public ModelAndView showForm()
	{
		return new ModelAndView("creerVoie","form", new Voie());
	}
	
	@RequestMapping(value="/saveVoie", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("voie") Voie voie)
	{
		voieM.create(voie);
		return new ModelAndView("redirect:/listerVoies");
	}
	
	@RequestMapping(value="/listerVoies")
	public ModelAndView list()
	{
		List<Voie> voies= voieM.list();
		return new ModelAndView("listerVoies","voies",voies);
	}
	
	@RequestMapping(value="/editVoie/{id}")
	public ModelAndView edit(@PathVariable Long id)
	{
		Voie voie =voieM.getById(id);
		return new ModelAndView("editerVoie", "form", voie);
	}
	
	@RequestMapping(value="/editSaveVoie", method=RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("voie") Voie voie)
	{
		voieM.edit(voie);
		return new ModelAndView("redirect:/listerVoies");
	}
	
	@RequestMapping(value="/deleteVoie/{id}")
	public ModelAndView delete(@PathVariable Long id)
	{
		voieM.delete(id);
		return new ModelAndView ("redirect:/listerVoies");
	}
}