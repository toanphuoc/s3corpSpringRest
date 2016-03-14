package com.s3corp.spring.service;

import java.util.List;

import com.s3corp.spring.model.User;

public interface UserService {

	User findById(long id);
    
    List<User> findByName(String name);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(long id);
 
    List<User> findAllUsers(); 
     
    void deleteAllUsers();
     
    public boolean isUserExist(User user);
    
}
