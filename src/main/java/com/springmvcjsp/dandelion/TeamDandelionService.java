package com.springmvcjsp.dandelion;

import java.util.List;

import org.springframework.data.domain.Page;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.springmvcjsp.model.Team;

public interface TeamDandelionService {

	/**
	 * @return the complete list of teams.
	 */
	public List<Team> findAll();

	/**
	 * @param maxResult
	 *            Max number of teams.
	 * @return a maxResult limited list of teams.
	 */
	public List<Team> findLimited(int maxResult);

	/**
	 * <p>
	 * Query used to populate the DataTables that display the list of teams.
	 * 
	 * @param criterias
	 *            The DataTables criterias used to filter the teams.
	 *            (maxResult, filtering, paging, ...)
	 * @return a bean that wraps all the needed information by DataTables to
	 *         redraw the table with the data.
	 */
	public DataSet<Team> findTeamsWithDatatablesCriterias(DatatablesCriterias criterias);
	
	
}