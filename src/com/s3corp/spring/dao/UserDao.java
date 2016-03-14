package com.s3corp.spring.dao;

import java.util.List;

import com.s3corp.spring.model.User;

public interface UserDao {

	public List<User> listUser();
	
	User findUser(long id);
	
	List<User> findUser(String name);
}
