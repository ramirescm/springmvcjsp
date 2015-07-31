package com.springmvcjsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public Team save(Team team) {
		return teamRepository.save(team);
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

}
