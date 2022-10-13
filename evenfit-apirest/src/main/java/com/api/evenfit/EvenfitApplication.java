package com.api.evenfit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.evenfit.domain.Role;
import com.api.evenfit.domain.User;
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
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role("ADMIN"));
			userService.saveRole(new Role("USER"));
			
			userService.saveUser(new User("admin@gmail.com", "1234", "admin", "surnames", 25, new Role()));
			userService.saveUser(new User("adri@gmail.com", "1234", "adri", "Perez", 25, new Role()));
			
			userService.addRoleToUser("admin@gmail.com", "ADMIN");
//			userService.addRoleToUser("adri@gmail.com", "USER");
		};
	}

}
