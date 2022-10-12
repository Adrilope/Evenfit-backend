package com.api.evenfit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.evenfit.domain.Role;
import com.api.evenfit.domain.User;
import com.api.evenfit.repo.RoleRepo;
import com.api.evenfit.repo.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor	// auto inject the repos
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepo userRepo;
	
	private final RoleRepo roleRepo;
	
	
	@Override
	public User saveUser(User user) {
		log.info("Saving new user {} to DB", user.getName());
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role {} to DB", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		log.info("Adding role {} to user {}", roleName, email);
		User user = userRepo.findByEmail(email);
		Role role = roleRepo.findByName(roleName);
		
		user.setRole(role);
		// at this point, auto save to DB (@Transactional)
	}

	@Override
	public User getUser(String email) {
		log.info("Fetching user {}", email);
		return userRepo.findByEmail(email);
	}

	@Override
	public List<User> getUsers() {
		log.info("Fetching all users");
		return userRepo.findAll(); 
	}

}
