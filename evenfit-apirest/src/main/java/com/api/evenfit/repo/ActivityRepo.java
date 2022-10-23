package com.api.evenfit.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.evenfit.domain.Activity;


public interface ActivityRepo extends JpaRepository<Activity, String>, PagingAndSortingRepository<Activity, String> {
	Activity findByName(String name);
	
	@Query(value="select a from Activity a")
	Page<Activity> getActivities(PageRequest pageRequest);
}
