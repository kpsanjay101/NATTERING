package com.sk.chitchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.chitchat.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
