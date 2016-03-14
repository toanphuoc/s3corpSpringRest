package com.s3corp.spring.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.s3corp.spring.model.User;

public interface UserController {

	public ResponseEntity<List<User>> listAllUsers();
	
	public ResponseEntity<User> getUser(long id);
	
	public ResponseEntity<List<User>> getUser(String name);
	
	public ResponseEntity<Void> createUser(User user, UriComponentsBuilder ucBuilder);
}
