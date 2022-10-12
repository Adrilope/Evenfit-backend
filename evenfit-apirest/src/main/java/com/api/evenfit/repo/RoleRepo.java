package com.api.evenfit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.evenfit.domain.Role;


public interface RoleRepo extends JpaRepository<Role, String>{
	Role findByName(String name);
}