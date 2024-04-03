package com.sk.chitchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.chitchat.model.FriendRequest;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Integer>{

}
