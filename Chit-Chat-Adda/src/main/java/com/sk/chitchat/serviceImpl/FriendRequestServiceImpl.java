package com.sk.chitchat.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.chitchat.exception.UserNotFoundException;
import com.sk.chitchat.model.FriendRequest;
import com.sk.chitchat.model.Users;
import com.sk.chitchat.repository.FriendRequestRepository;
import com.sk.chitchat.repository.FriendsRepository;
import com.sk.chitchat.repository.UsersRepository;
import com.sk.chitchat.service.FriendRequestService;

@Service
public class FriendRequestServiceImpl implements FriendRequestService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private FriendRequestRepository friendRequestRepository;
	
	@Autowired
	private FriendsRepository friendsRepository;

	@Override
	public String sentFriendRequest(int senderId, int recieverId) {
		Optional<Users> opSender = usersRepository.findById(senderId);
		Optional<Users> opReciever = usersRepository.findById(recieverId);
		if(opSender.isEmpty() || opReciever.isEmpty()) {
			throw new UserNotFoundException("User doesn't exist with this id");
		}
		Users senderUser = opSender.get();
		Users recieverUser = opReciever.get();
		
		FriendRequest req = new FriendRequest();
		req.setSender(senderUser);
		req.setReceiver(recieverUser);
		
		friendRequestRepository.save(req);
		
		return "Friend Request Sent successfully";
	}

}
