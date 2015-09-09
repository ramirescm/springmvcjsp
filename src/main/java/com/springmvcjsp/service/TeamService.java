package com.springmvcjsp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springmvcjsp.model.Team;

public interface TeamService {

	List<Team> findAll();
	
	Page<Team> findAllOrderByIdAsc(Pageable pageable);
	
	Team findById(Long id);

	void delete(Long id);

	void save(Team team);

}
