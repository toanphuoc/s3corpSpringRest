package com.s3corp.spring.dao;

import java.util.List;

import com.s3corp.spring.model.User;

public interface UserDao {

	public List<User> listUser();
	
	public User findUser(long id);
}
