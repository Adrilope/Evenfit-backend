package com.api.evenfit.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.evenfit.domain.Activity;
import com.api.evenfit.service.ActivityService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ActivityController {
	private final ActivityService activityService;
	
	
	@GetMapping("/activities")
	public ResponseEntity<List<Activity>> getActivities() {
		return ResponseEntity.ok().body(activityService.getActivities());
	}
	
	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping("/activities/page/{page}")
	public ResponseEntity<Page<Activity>> getActivities(@PathVariable Integer page) {
		return ResponseEntity.ok().body(activityService.getActivities(page));
	}
	
	
	@GetMapping("/activities/{name}")
	public ResponseEntity<Activity> getActivity(@PathVariable String name){
		return ResponseEntity.ok().body(activityService.getActivity(name));
	}
	
	@CrossOrigin(origins = {"http://localhost:3000"})
	@GetMapping("/activities/some")
	public ResponseEntity<List<Activity>> getSomeActivities() {
		return ResponseEntity.ok().body(activityService.getSomeActivities());
	}
}
