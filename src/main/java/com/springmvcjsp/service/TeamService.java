package com.springmvcjsp.service;

import java.util.List;

import com.springmvcjsp.model.Team;

public interface TeamService {

	List<Team> findAll();

	Team findById(Long id);

	void delete(Long id);

	Team save(Team team);

}
