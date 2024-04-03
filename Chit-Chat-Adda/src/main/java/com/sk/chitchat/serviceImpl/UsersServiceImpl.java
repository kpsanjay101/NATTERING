package com.sk.chitchat.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.chitchat.exception.NoFriendsExistException;
import com.sk.chitchat.exception.UserNotFoundException;
import com.sk.chitchat.exception.UsersAlreadyExistException;
import com.sk.chitchat.model.Friends;
import com.sk.chitchat.model.Users;
import com.sk.chitchat.repository.UsersRepository;
import com.sk.chitchat.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users addNewUsers(Users users) {
				
		Optional<Users> opUser = usersRepository.findById(users.getUser_id());
		if(opUser.isPresent()) {
			throw new UsersAlreadyExistException("User allready exist with this user_id");
		}
		
		return usersRepository.save(users);
	
	}

	@Override
	public List<Users> getAllFriends(Integer userId) {
		
		List<Users> usersList = new ArrayList<>();
		
		Optional<Users> opUser = usersRepository.findById(userId);
		if(opUser.isEmpty()) {
			throw new UserNotFoundException("User doesn't exist with this user_id");
		}
		Users users = opUser.get();
		
		List<Friends> friendList = users.getFriendships();
		for(Friends friend : friendList) {
			usersList.add(friend.getFriend());
		}
		if(usersList.isEmpty()) {
			throw new NoFriendsExistException("Make friend first");
		}else
		return usersList;
	}

	@Override
	public String removeFriends(Integer friendsId) {
		// TODO Auto-generated method stub
		return null;
	}

}

