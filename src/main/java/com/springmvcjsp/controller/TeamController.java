package com.springmvcjsp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvcjsp.model.Team;
import com.springmvcjsp.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	private final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("team/form");
		modelAndView.addObject("team", new Team());
		return modelAndView;
	}
	
	@RequestMapping(value={"/", "/list"}, method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("team/list");
		List<Team> teams = (List<Team>) teamService.findAll();
		modelAndView.addObject("teams", teams);
		return modelAndView;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("team/form");
		Team team = teamService.findById(id);
		modelAndView.addObject("team",team);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated  @ModelAttribute Team team, final RedirectAttributes redirectAttrs, BindingResult result) {
		if (result.hasErrors()) {
			return "team/add";
		} else {
			if(team.getId() == null){
				LOGGER.debug("save() : {}", team);
				redirectAttrs.addFlashAttribute("message", "team added successfully!");
			}else{
				LOGGER.debug("update() : {}", team);
				redirectAttrs.addFlashAttribute("message", "team updated successfully!");
			}
 
			teamService.save(team);
 
			// POST/REDIRECT/GET
			return "redirect:/team/" + team.getId();
		}
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("team/list");
		teamService.delete(id);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		
		List<Team> teams = (List<Team>) teamService.findAll();
		modelAndView.addObject("teams", teams);
		return modelAndView;
	}
}
