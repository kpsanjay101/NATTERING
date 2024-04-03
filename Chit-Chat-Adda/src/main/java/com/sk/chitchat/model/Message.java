package com.sk.chitchat.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime timestamp;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Users sender;
	
    

}
