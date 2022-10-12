package com.api.evenfit.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String email;
	
	private String password;
	
	private String name;

	private String surname;
	
	private Integer age;
	
	@ManyToOne
	private Role role = new Role();

}