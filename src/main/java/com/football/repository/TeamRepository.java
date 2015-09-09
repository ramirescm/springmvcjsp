package com.football.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.football.model.Team;

public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
	
	
}
