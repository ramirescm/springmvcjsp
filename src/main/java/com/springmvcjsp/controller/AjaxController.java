package com.springmvcjsp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.github.dandelion.datatables.core.ajax.DatatablesResponse;
import com.github.dandelion.datatables.extras.spring3.ajax.DatatablesParams;
import com.springmvcjsp.dandelion.TeamDandelionService;
import com.springmvcjsp.model.Team;

@Controller
@RequestMapping(value="/ajax", method = RequestMethod.GET)
public class AjaxController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AjaxController.class);

	@Autowired
	private TeamDandelionService teamService;

	@RequestMapping(value = "/teams-no-server-side")
	public @ResponseBody
	List<Team> findAll() {
		return teamService.findLimited(200);
	}

	@RequestMapping(value = "/teams-no-spring")
	public @ResponseBody
	DatatablesResponse<Team> findAllForDataTables(HttpServletRequest request) {
		DatatablesCriterias criterias = DatatablesCriterias.getFromRequest(request);
		DataSet<Team> teams = teamService.findTeamsWithDatatablesCriterias(criterias);
		return DatatablesResponse.build(teams, criterias);
	}

	@RequestMapping(value = "/teams")
	public @ResponseBody
	DatatablesResponse<Team> findAllForDataTablesFullSpring(@DatatablesParams DatatablesCriterias criterias) {
		LOGGER.info("Processing datatbles ajax request..");
		DataSet<Team> dataSet = teamService.findTeamsWithDatatablesCriterias(criterias);
		return DatatablesResponse.build(dataSet, criterias);
	}
	
	@RequestMapping(value = "/teams-via-post", method = RequestMethod.POST)
	public @ResponseBody
	DatatablesResponse<Team> findAllForDataTablesFullSpringViaPost(@DatatablesParams DatatablesCriterias criterias) {
		DataSet<Team> dataSet = teamService.findTeamsWithDatatablesCriterias(criterias);
		return DatatablesResponse.build(dataSet, criterias);
	}
	
	@RequestMapping(value = "/emptyList")
	public @ResponseBody
	List<Team> emptyList(HttpServletRequest request) {
		return new ArrayList<Team>();
	}
	
	@RequestMapping(value = "/nullList")
	public @ResponseBody
	List<Team> nullList(HttpServletRequest request) {
		return null;
	}
}