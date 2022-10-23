package com.api.evenfit.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.api.evenfit.domain.Activity;


public interface ActivityService {
	Activity saveActivity(Activity activity);
	
	Activity getActivity(String activityName);
	
	List<Activity> getActivities();
	
	Page<Activity> getActivities(Integer page);
}