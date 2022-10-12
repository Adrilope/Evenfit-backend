package com.api.evenfit.service;

import java.util.List;

import com.api.evenfit.domain.Role;
import com.api.evenfit.domain.User;


public interface UserService {
	User saveUser(User user);
	
	Role saveRole(Role role);
	
	void addRoleToUser(String email, String roleName);
	
	User getUser(String email);
	
	List<User> getUsers();
}