package com.example.Springsecurity.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Roles {
	@Id
	private String roleId= UUID.randomUUID().toString();
	@Enumerated(EnumType.STRING)
	private RoleEvent roleEvent;
}
