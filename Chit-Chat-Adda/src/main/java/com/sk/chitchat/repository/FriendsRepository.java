package com.sk.chitchat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.chitchat.model.Friends;
import com.sk.chitchat.model.Users;

public interface FriendsRepository extends JpaRepository<Friends, Integer>{
	
	List<Friends> findAllByUser(Users users);

}
