package com.sk.chitchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.chitchat.model.Friends;
import com.sk.chitchat.model.Users;
import com.sk.chitchat.service.FriendsService;

@RestController
@RequestMapping("/friends")
public class FriendsController {
	
	@Autowired
	private FriendsService friendsService;
	
	@PostMapping("acceptFriendRequest/{friendReqId}")
	public ResponseEntity<String> acceptFriendRequest(@PathVariable Integer friendReqId){
		
		return new ResponseEntity<String>(friendsService.acceptFriendRequest(friendReqId), HttpStatus.OK);
	}
	
	@DeleteMapping("removeFriendRequest/{friendReqId}")
	public ResponseEntity<String> removeFriendRequest(@PathVariable Integer friendReqId){
		
		return new ResponseEntity<String>(friendsService.removeFriendRequest(friendReqId) , HttpStatus.OK);
	}

}
