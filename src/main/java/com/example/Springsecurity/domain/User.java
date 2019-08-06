package com.example.Springsecurity.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class User {
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",joinColumns ={@JoinColumn(name="user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
	List<Roles> roles;
	@Id
	private String userId = UUID.randomUUID().toString();
	private String userName;
	private String password;

	public User(User user) {
		this.userName=user.getUserName();
		this.password=user.getPassword();
		this.roles=user.getRoles();
		this.userId=user.getUserId();
	}
}
