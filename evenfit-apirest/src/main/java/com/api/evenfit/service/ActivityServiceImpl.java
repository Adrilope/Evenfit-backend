package com.api.evenfit.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.evenfit.domain.Activity;
import com.api.evenfit.repo.ActivityRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor	// auto inject the repos
@Transactional
@Slf4j
public class ActivityServiceImpl implements ActivityService {
	private final ActivityRepo activityRepo;
	

	@Override
	public Activity saveActivity(Activity activity) {
		log.info("Saving new activity {} to DB", activity.getName());
		return activityRepo.save(activity);
	}

	@Override
	public Activity getActivity(String activityName) {
		log.info("Fetching activity {}", activityName);
		return activityRepo.findByName(activityName);
	}
	
	@Override
	public List<Activity> getActivities() {
		log.info("Fetching all activities");
		return activityRepo.findAll();
	}

	@Override
	public Page<Activity> getActivities(Integer page) {
		PageRequest pageRequest;
		pageRequest = PageRequest.of(page-1, 12);
		
		return activityRepo.getActivities(pageRequest);
	}

	@Override
	public List<Activity> getSomeActivities() {
		return activityRepo.getSomeActivities(PageRequest.of(0,3));
	}
	
}
