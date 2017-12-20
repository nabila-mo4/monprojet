package org.opencr.projet.monprojet;


import java.util.List;

import org.opencr.projet.monprojet.business.contract.manager.TopoManager;
import org.opencr.projet.monprojet.model.Topo;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;  


@Controller
public class TopoController{
	//@Autowired
	TopoManager topoM;
	
	@RequestMapping(value="/createTopo")
	public ModelAndView showForm()
	{
		return new ModelAndView("creerTopo","form", new Topo());
	}
	
	@RequestMapping(value="/saveTopo", method=RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("topo") Topo topo)
	{
		topoM.create(topo);
		return new ModelAndView("redirect:/listerTopos");
	}
	
	@RequestMapping(value="/listerTopos")
	public ModelAndView list()
	{
		List<Topo> topos= topoM.list();
		return new ModelAndView("listerTopos","topos",topos);
	}
	
	@RequestMapping(value="/editTopo/{id}")
	public ModelAndView edit(@PathVariable Long id)
	{
		Topo topo =topoM.getById(id);
		return new ModelAndView("editerTopo", "form", topo);
	}
	
	@RequestMapping(value="/editSaveTopo", method=RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("topo") Topo topo)
	{
		topoM.edit(topo);
		return new ModelAndView("redirect:/listerTopos");
	}
	
	@RequestMapping(value="/deleteTopo/{id}")
	public ModelAndView delete(@PathVariable Long id)
	{
		topoM.delete(id);
		return new ModelAndView ("redirect:/listerTopos");
	}
}