package com.football.dandelion;

import java.util.List;

import com.football.model.Team;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;

public interface TeamDandelionRepository {

	/**
	 * @return the complete list of persons.
	 */
	public List<Team> findAll();

	/**
	 * @param maxResult
	 *            Max number of persons.
	 * @return a maxResult limited list of persons.
	 */
	public List<Team> findLimited(int maxResult);

	/**
	 * <p>
	 * Query used to populate the DataTables that display the list of persons.
	 * 
	 * @param criterias
	 *            The DataTables criterias used to filter the persons.
	 *            (maxResult, filtering, paging, ...)
	 * @return a filtered list of persons.
	 */
	public List<Team> findTeamWithDatatablesCriterias(DatatablesCriterias criterias);
	
	

	/**
	 * <p>
	 * Query used to return the number of filtered persons.
	 * 
	 * @param criterias
	 *            The DataTables criterias used to filter the persons.
	 *            (maxResult, filtering, paging, ...)
	 * @return the number of filtered persons.
	 */
	public Long getFilteredCount(DatatablesCriterias criterias);

	/**
	 * @return the total count of persons.
	 */
	public Long getTotalCount();
}