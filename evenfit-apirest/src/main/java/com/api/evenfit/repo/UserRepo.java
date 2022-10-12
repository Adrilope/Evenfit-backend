package com.api.evenfit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.evenfit.domain.User;


public interface UserRepo extends JpaRepository<User, String>{
	User findByEmail(String email);
}