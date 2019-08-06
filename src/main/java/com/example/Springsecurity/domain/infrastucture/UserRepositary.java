package com.example.Springsecurity.domain.infrastucture;

import com.example.Springsecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositary extends JpaRepository<User,String> {

	void deleteByuserName(String username);

	Optional<User> findByUserName(String userName);
}
