package com.sk.chitchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.chitchat.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
