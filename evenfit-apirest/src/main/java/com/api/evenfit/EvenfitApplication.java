package com.api.evenfit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.evenfit.domain.Activity;
import com.api.evenfit.domain.Role;
import com.api.evenfit.domain.User;
import com.api.evenfit.service.ActivityService;
import com.api.evenfit.service.UserService;

@SpringBootApplication
public class EvenfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvenfitApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// execute after init
	@Bean
	CommandLineRunner run(UserService userService, ActivityService activityService) {
		return args -> {
			userService.saveRole(new Role("ROLE_ADMIN"));
			userService.saveRole(new Role("ROLE_USER"));
			
			userService.saveUser(new User("admin@gmail.com", "1234", "admin", "surnames", 25, new Role()));
			userService.saveUser(new User("adri@gmail.com", "1234", "adri", "Perez", 25, new Role()));
			
			userService.addRoleToUser("admin@gmail.com", "ROLE_ADMIN");

			activityService.saveActivity(new Activity("Natacion", "Aqua", "Media"));
			activityService.saveActivity(new Activity("Yoga", "Mental", "Baja"));
			activityService.saveActivity(new Activity("Tenis", "Cardio", "Alta"));
			activityService.saveActivity(new Activity("Zumba", "Dance", "Media"));
			
			activityService.saveActivity(new Activity("Bike", "Cardio", "Media"));
			activityService.saveActivity(new Activity("Stretching", "Mental", "Baja"));
			activityService.saveActivity(new Activity("Step", "Cardio", "Media"));
			activityService.saveActivity(new Activity("Aerobic", "Dance", "Media"));
			
			activityService.saveActivity(new Activity("Box", "Cardio", "Media"));
			activityService.saveActivity(new Activity("Pilates", "Mental", "Baja"));
			activityService.saveActivity(new Activity("Cinta", "Cardio", "Alta"));
			activityService.saveActivity(new Activity("Mindfulness", "Mental", "Baja"));
			
			activityService.saveActivity(new Activity("Club de nadadores", "Aqua", "Media"));
			activityService.saveActivity(new Activity("Zen", "Mental", "Baja"));
		};
	}

}
