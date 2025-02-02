package com.expensetracker.management.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class RestResponse {
	private Object responseBody;
	private HttpStatus status;
}
