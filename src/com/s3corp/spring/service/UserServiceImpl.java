package com.s3corp.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;

import com.s3corp.spring.dao.UserDao;
import com.s3corp.spring.model.User;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	private static AtomicLong counter = new AtomicLong();
	private static List<User> users = new ArrayList<User>();
			
	static {
		users = populateDummyUsers();
	}
	
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"Sam",30, 70000));
        users.add(new User(counter.incrementAndGet(),"Tom",40, 50000));
        users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));
        users.add(new User(counter.incrementAndGet(),"Silvia",50, 40000));
        return users;
	}
	
	
	
	@Override
	public User findById(long id) {
		return userDao.findUser(id);
	}

	@Override
	public List<User> findByName(String name) {
		return userDao.findUser(name);
	}

	@Override
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	@Override
	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	@Override
	public void deleteUserById(long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.listUser();
	}

	@Override
	public void deleteAllUsers() {
		users.clear();
	}

	@Override
	public boolean isUserExist(User user) {
		return findByName(user.getName())!= null;
	}

}
