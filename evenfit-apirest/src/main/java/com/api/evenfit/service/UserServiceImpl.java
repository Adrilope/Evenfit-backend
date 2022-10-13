package com.api.evenfit.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class UserServiceImpl implements UserService, UserDetailsService {
	private final UserRepo userRepo;
	
	private final RoleRepo roleRepo;
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(email);
		if (user == null) {
			log.error("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		else {
			log.info("User found in DB: {}", email);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
	
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
