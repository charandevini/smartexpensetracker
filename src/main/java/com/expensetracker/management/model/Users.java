package com.expensetracker.management.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.Data;

@Entity
@TypeDef(name = "json", typeClass = JsonType.class) 
@Table(name = "users")
@Data
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	@NotBlank(message = "UserName is Mandatory")
	@Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
	@Column(name = "username")
	private String userName;
	@NotBlank(message = "Password is mandatory")
	private String password;
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Invalid email format")
	private String email;
	@Type(type = "json")
	@Column(columnDefinition = "json")
	private JsonNode preferences;
	@NotBlank(message = "Email is mandatory")
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_at")
	@UpdateTimestamp
	private Timestamp createdAt;
}
