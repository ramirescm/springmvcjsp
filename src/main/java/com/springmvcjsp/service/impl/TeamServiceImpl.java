package com.springmvcjsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvcjsp.model.Team;
import com.springmvcjsp.repository.TeamRepository;
import com.springmvcjsp.service.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private TeamRepository teamRepository;

	public void save(Team team) {
		teamRepository.save(team);
	}

	public void delete(Long id) {
		teamRepository.delete(id);
	}

	public Team findById(Long id) {
		return teamRepository.findOne(id);
	}

	public List<Team> findAll() {
		return (List<Team>) teamRepository.findAll();
	}

	@Override
	public Page<Team> findAllOrderByIdAsc(Pageable pageable) {
		Page<Team> teams = teamRepository.findAll(pageable);
		return teams;
	}
	
//	public List<Team> findTeams(String search) {
//		search = StringUtils.replace(search, ",", "%");
//		Page<Team> essay = teamRepository.findAll(search, search, new PageRequest(0, 10));
//		return essay.getContent();
//	}


//	@Override
//	public DataSet<Team> findWithDatatablesCriterias(DatatablesCriterias criterias) {
//		String query = criterias.getSearch();
//		query = StringUtils.replace(query, ",", "%");
//		
//		int page = criterias.getStart() / criterias.getLength();
//		int size = criterias.getLength();
//		Pageable pagable = new PageRequest(page, size);
//		
//		Page<Team> essayPage = teamRepository.findAll(query, query, pagable);
//		
//		List<Team> rows = essayPage.getContent();
//		Long totalDisplayRecords = essayPage.getTotalElements();
//		Long totalRecords = essayPage.getTotalElements();
//		
//		DataSet<Team> dataSet = new DataSet<Team>(rows, totalRecords, totalDisplayRecords);
//		return dataSet;
//	}
//
//	@Override
//	public Page<Team> findTeams(Integer pageNo, Integer listSize, String search) {
//		search = StringUtils.replace(search, ",", "%");
//		Pageable pagable = new PageRequest(pageNo - 1, listSize, Sort.Direction.DESC, "id");
//		Page<Team> page = teamRepository.findAll(search, search, pagable);
//		return page;
//	}
//
//	@Override
//	public List<Team> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}



}
