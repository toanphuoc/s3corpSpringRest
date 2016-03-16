package com.s3corp.spring.controller;

import java.util.List;

import javax.persistence.QueryHint;

import org.hibernate.annotations.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.s3corp.spring.model.User;
import com.s3corp.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController{

	@Autowired
	private UserService userService;
	
	@Override
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users= userService.findAllUsers();
		if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "findUser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		User user = userService.findById(id);
		if(user == null){
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void createUser(
			
			@RequestParam(value = "name") String name,@RequestParam(value = "age") int age,
											@RequestParam(value = "salary") double salary, UriComponentsBuilder ucBuilder) {
//		if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
// 
        userService.saveUser(name, age, salary);
 
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	//	return userService.saveUser(name, age, salary);
	}

	@Override
	@RequestMapping(value = "findUserByName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUser(@PathVariable("name") String name) {
		List<User> users = userService.findByName(name);
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
