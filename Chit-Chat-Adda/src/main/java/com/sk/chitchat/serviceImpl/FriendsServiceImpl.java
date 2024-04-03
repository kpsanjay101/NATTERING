package com.sk.chitchat.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.chitchat.exception.FriendRequestNotFoundException;
import com.sk.chitchat.exception.NoFriendsExistException;
import com.sk.chitchat.exception.UserNotFoundException;
import com.sk.chitchat.model.FriendRequest;
import com.sk.chitchat.model.Friends;
import com.sk.chitchat.model.Users;
import com.sk.chitchat.repository.FriendRequestRepository;
import com.sk.chitchat.repository.FriendsRepository;
import com.sk.chitchat.repository.UsersRepository;
import com.sk.chitchat.service.FriendsService;

@Service
public class FriendsServiceImpl implements FriendsService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private FriendRequestRepository friendRequestRepository;
	
	@Autowired
	private FriendsRepository friendsRepository;

	@Override
	public String acceptFriendRequest(int friendRequest_id) {
	    Optional<FriendRequest> opFriendRequest = friendRequestRepository.findById(friendRequest_id);
	    if (opFriendRequest.isPresent()) {
	        FriendRequest friendRequest = opFriendRequest.get();
	        friendRequest.setAccepted(true);
	        friendRequestRepository.save(friendRequest);

	        Users sender = friendRequest.getSender();
	        Users receiver = friendRequest.getReceiver();
	     
	        Friends friends1 = new Friends();
	        friends1.setUser(sender);
	        friends1.setFriend(receiver);
	        friendsRepository.save(friends1);
	        
	        Friends friends2 = new Friends();
	        friends2.setUser(receiver);
	        friends2.setFriend(sender);
	        friendsRepository.save(friends2);

	    } else {
	        return "Friend request not found";
	    }

	    return "Friend request is accepted";
	}

	@Override
	public String removeFriendRequest(int friendRequest_id) {
		Optional<FriendRequest> opFriendRequest = friendRequestRepository.findById(friendRequest_id);
		if(opFriendRequest.isPresent()) {
			FriendRequest friendRequest = opFriendRequest.get();
			boolean ans = friendRequest.isAccepted();
			if(ans == false) {
				friendRequestRepository.deleteById(friendRequest_id);
			}
		}else throw new FriendRequestNotFoundException("No friend request found with this id "+friendRequest_id);
		return "Friend request removed";
	}



}
