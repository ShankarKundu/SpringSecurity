package com.example.Springsecurity.domain.infrastucture;

import com.example.Springsecurity.domain.RoleEvent;
import com.example.Springsecurity.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolesRepositary extends JpaRepository<Roles,String> {

	Roles findByRoleEvent(String name);

	List<Roles> findByRoleEventIn(List<RoleEvent> collect);
}
