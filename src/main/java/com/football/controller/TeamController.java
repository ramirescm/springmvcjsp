package com.football.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.football.model.Team;
import com.football.service.TeamService;
import com.football.utils.MessageHelper;

@Controller
public class TeamController {

	private final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

	private final TeamService teamService;

	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}

	@RequestMapping(value = "/team/list")
	public String list() {
		return "team/list";
	}

	@RequestMapping(value = "/team/add")
	public String initCreationForm(Model model) {
		Team team = new Team();
		model.addAttribute("team", team);
		LOGGER.debug("# Team addGet : {}", team);
		return "team/form";
	}

	@RequestMapping(value = "/team/add", method = RequestMethod.POST)
	public String processCreationForm(Model model, @Valid Team team, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "team/form";
		} else {
			LOGGER.debug("# Team addPost : {}", team);
			teamService.save(team);
			MessageHelper.addSuccessAttribute(redirectAttributes, "registro.salvo");
			return "redirect:/team/" + team.getId() + "/edit";
		}
	}

	@RequestMapping(value = "/team/{teamId}/edit", method = RequestMethod.GET)
	public String editGet(@PathVariable("teamId") Long teamId, Model model) {
		Team team = teamService.findById(teamId);
		LOGGER.debug("# Team editGet : {}", team);
		model.addAttribute("team", team);
		return "team/form";
	}

	// public String editPost(@PathVariable("teamId") Long teamId, @Valid
	// @ModelAttribute Team team,
	@RequestMapping(value = "/team/{teamId}/edit", method = RequestMethod.PUT)
	public String editPost(@PathVariable("teamId") Long teamId, @Valid Team team, BindingResult result,
			RedirectAttributes redirectAttributes) {
		LOGGER.debug("# Team editPost : {}", team);
		if (result.hasErrors()) {
			return "team/form";
		} else {
			team.setId(teamId);
			teamService.save(team);
			MessageHelper.addSuccessAttribute(redirectAttributes, "registro.atualizado");
			return "redirect:/team/{teamId}/edit";
		}
	}

	@RequestMapping(value = "/team/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		long start = System.currentTimeMillis();
		teamService.delete(id);
		long end = System.currentTimeMillis();
		System.out.println("Fim " + (end - start) + "ms");
		MessageHelper.addSuccessAttribute(redirectAttributes, "registro.excluido");
		return "redirect:/team/list";
	}

	/**
	 * Custom handler for displaying an owner.
	 *
	 * @param ownerId
	 *            the ID of the owner to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/team/{teamId}")
	public ModelAndView showTeam(@PathVariable("teamId") Long teamId) {
		ModelAndView mav = new ModelAndView("team/view");
		mav.addObject(teamService.findById(teamId));
		return mav;
	}
}
