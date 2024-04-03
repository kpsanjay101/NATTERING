package com.sk.chitchat.service;

import java.util.List;

import com.sk.chitchat.model.Friends;
import com.sk.chitchat.model.Users;

public interface FriendsService {
	
	public String acceptFriendRequest(int friendRequest_id);
	
	public String removeFriendRequest(int friendRequest_id);
	

}
