package com.sk.chitchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.chitchat.model.Friends;
import com.sk.chitchat.model.Users;
import com.sk.chitchat.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping("/addUsers")
	public ResponseEntity<Users> addNewUsers(@RequestBody Users users){
		return new ResponseEntity<Users>(usersService.addNewUsers(users), HttpStatus.CREATED)  ;
	}
	
	@GetMapping("/getAllFriends/{userId}")
	public ResponseEntity<List<Users>> getAllFriends(@PathVariable Integer userId){
		return new ResponseEntity<>(usersService.getAllFriends(userId) , HttpStatus.CREATED)  ;
	}

}
