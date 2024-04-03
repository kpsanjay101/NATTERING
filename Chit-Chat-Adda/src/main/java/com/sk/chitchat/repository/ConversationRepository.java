package com.sk.chitchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.chitchat.model.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Integer>{

}
