package com.sk.chitchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.chitchat.service.FriendRequestService;

@RestController
@RequestMapping("/friendRequest")
public class FriendRequestController {
	
	@Autowired
	private FriendRequestService friendRequestService;
	
	
	@PostMapping("/sendFriendsRequest/{senderID}/{recieverID}")
	public ResponseEntity<String> makeFrineds(@PathVariable Integer senderID, @PathVariable Integer recieverID){
		return new ResponseEntity<String>(friendRequestService.sentFriendRequest(senderID, recieverID), HttpStatus.OK);
	}

}
