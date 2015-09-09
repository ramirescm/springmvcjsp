package com.football.dandelion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.model.Team;
import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;

@Service
public class TeamDandelionServiceImpl implements TeamDandelionService {

	@Autowired
	private TeamDandelionRepository teamRepository;

	/**
	 * {@inheritDoc}
	 */
	public List<Team> findAll() {
		return teamRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Team> findLimited(int maxResult) {
		return teamRepository.findLimited(maxResult);
	}

	/**
	 * {@inheritDoc}
	 */
	public DataSet<Team> findTeamsWithDatatablesCriterias(DatatablesCriterias criterias) {

		List<Team> teams = teamRepository.findTeamWithDatatablesCriterias(criterias);
		Long count = teamRepository.getTotalCount();
		Long countFiltered = teamRepository.getFilteredCount(criterias);

		return new DataSet<Team>(teams, count, countFiltered);
	}

}