package com.sk.chitchat.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	private String username;

    private String password;

    private String email;
    
    @JsonIgnore
    @OneToMany(mappedBy = "createdBy")
    private List<Conversation> conversations;
    
    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;
    
    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    private List<FriendRequest> sentFriendRequests;
    
    @JsonIgnore
    @OneToMany(mappedBy = "receiver")
    private List<FriendRequest> receivedFriendRequests;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Friends> friendships;

    @JsonIgnore
    @OneToMany(mappedBy = "friend")
    private List<Friends> friendsWith;

}
