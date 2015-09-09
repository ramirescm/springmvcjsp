package com.springmvcjsp.dandelion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.github.dandelion.datatables.core.ajax.ColumnDef;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.springmvcjsp.model.Team;

@Repository
public class TeamJpaRepository implements TeamDandelionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @return the complete list of Teams.
	 */
	public List<Team> findAll() {
		TypedQuery<Team> query = entityManager.createQuery("SELECT t FROM Team t", Team.class);
		return query.getResultList();
	}

	/**
	 * @param maxResult
	 *            Max number of Teams.
	 * @return a maxResult limited list of Teams.
	 */
	public List<Team> findLimited(int maxResult) {
		TypedQuery<Team> query = entityManager.createQuery("SELECT t FROM Team t", Team.class);
		query.setMaxResults(maxResult);
		return query.getResultList();
	}

	/**
	 * <p>
	 * Query used to populate the DataTables that display the list of Teams.
	 * 
	 * @param criterias
	 *            The DataTables criterias used to filter the Teams. (maxResult,
	 *            filtering, paging, ...)
	 * @return a filtered list of Teams.
	 */
	@SuppressWarnings("deprecation")
	public List<Team> findTeamWithDatatablesCriterias(DatatablesCriterias criterias) {

		StringBuilder queryBuilder = new StringBuilder("SELECT t FROM Team t");

		/**
		 * Step 1: global and individual column filtering
		 */
		queryBuilder.append(TeamRepositoryUtils.getFilterQuery(criterias));

		/**
		 * Step 2: sorting
		 */
		if (criterias.hasOneSortedColumn()) {

			List<String> orderParams = new ArrayList<String>();
			queryBuilder.append(" ORDER BY ");
			for (ColumnDef columnDef : criterias.getSortingColumnDefs()) {
				orderParams.add("t." + columnDef.getName() + " " + columnDef.getSortDirection());
			}

			Iterator<String> itr2 = orderParams.iterator();
			while (itr2.hasNext()) {
				queryBuilder.append(itr2.next());
				if (itr2.hasNext()) {
					queryBuilder.append(" , ");
				}
			}
		}

		TypedQuery<Team> query = entityManager.createQuery(queryBuilder.toString(), Team.class);

		/**
		 * Step 3: paging
		 */
		query.setFirstResult(criterias.getStart());
		query.setMaxResults(criterias.getLength());

		return query.getResultList();
	}

	/**
	 * <p>
	 * Query used to return the number of filtered Teams.
	 * 
	 * @param criterias
	 *            The DataTables criterias used to filter the Teams. (maxResult,
	 *            filtering, paging, ...)
	 * @return the number of filtered Teams.
	 */
	public Long getFilteredCount(DatatablesCriterias criterias) {

		StringBuilder queryBuilder = new StringBuilder("SELECT t FROM Team t");

		queryBuilder.append(TeamRepositoryUtils.getFilterQuery(criterias));

		Query query = entityManager.createQuery(queryBuilder.toString());
		return Long.parseLong(String.valueOf(query.getResultList().size()));
	}

	/**
	 * @return the total count of Teams.
	 */
	public Long getTotalCount() {
		Query query = entityManager.createQuery("SELECT COUNT(t) FROM Team t");
		return (Long) query.getSingleResult();
	}
}