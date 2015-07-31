package com.springmvcjsp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springmvcjsp.model.Team;

public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
	
}
