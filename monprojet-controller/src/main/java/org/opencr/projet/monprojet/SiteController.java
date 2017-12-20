package org.opencr.projet.monprojet;


import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.SiteManager;
import org.opencr.projet.monprojet.model.Site;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  


@Controller
public class SiteController{
	//@Autowired
	SiteManager siteM;
	
	@RequestMapping(value="/createSite")
	public ModelAndView showForm()
	{
		return new ModelAndView("creerSite","form", new Site());
	}
	
	@RequestMapping(value="/saveSite", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("site") Site site)
	{
		siteM.create(site);
		return new ModelAndView("redirect:/listerSites");
	}
	
	@RequestMapping(value="/listerSites")
	public ModelAndView list()
	{
		List<Site> sites= siteM.list();
		return new ModelAndView("listerSites","sites",sites);
	}
	
	@RequestMapping(value="/editSite/{id}")
	public ModelAndView edit(@PathVariable Long id)
	{
		Site site =siteM.getById(id);
		return new ModelAndView("editerSite", "form", site);
	}
	
	@RequestMapping(value="/editSaveSite", method=RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("site") Site site)
	{
		siteM.edit(site);
		return new ModelAndView("redirect:/listerSites");
	}
	
	@RequestMapping(value="/deleteSite/{id}")
	public ModelAndView delete(@PathVariable Long id)
	{
		siteM.delete(id);
		return new ModelAndView ("redirect:/listerSites");
	}
}