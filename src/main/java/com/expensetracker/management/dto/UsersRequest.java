package com.expensetracker.management.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersRequest {
	private Long userId;
	private String userName;
	private String password;
	private String email;
	private JsonNode preferences;
	private String createdBy;
	private Timestamp createdAt;
}
