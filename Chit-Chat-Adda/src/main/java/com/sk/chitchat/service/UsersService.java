package com.sk.chitchat.service;

import java.util.List;

import com.sk.chitchat.model.Friends;
import com.sk.chitchat.model.Users;

public interface UsersService {
	
	public Users addNewUsers(Users users);
	public List<Users> getAllFriends(Integer userId);
	public String removeFriends(Integer friendsId);
	
	
	

}
