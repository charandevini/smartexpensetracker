package com.expensetracker.management.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.management.dto.UsersRequest;
import com.expensetracker.management.model.ValidList;
import com.expensetracker.management.service.UsersService;
import com.expensetracker.management.util.ErrorResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UsersController {

	private ErrorResponse errorResponse;
	private UsersService usersService;

	@PostMapping(value = "/saveorupdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveOrUpdateUsers(@Valid @RequestBody UsersRequest usersRequest,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors())
				return errorResponse.setValidationErrorResponse(bindingResult);
			UsersRequest users = usersService.saveOrUpdateUsers(usersRequest);
			return Optional.ofNullable(users).map(u -> new ResponseEntity<>(u, HttpStatus.CREATED))
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			log.error("Exception while saving/updating users: {}", e.getMessage(), e);
			return errorResponse.setExceptionResponse(e);
		}
	}

	@PostMapping(value = "/list/saveorupdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveOrUpdateUsersList(@Valid @RequestBody ValidList<UsersRequest> usersRequests,
			BindingResult bindingResult) {
		List<UsersRequest> usersList;

		try {
			if (bindingResult.hasErrors())
				return errorResponse.setValidationErrorResponse(bindingResult);
			usersList = usersService.saveOrUpdateUsersList(usersRequests.getList());
			return Optional.ofNullable(usersList).map(u -> new ResponseEntity<>(u, HttpStatus.CREATED))
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			log.error("Exception while saving/updating users: {}", e.getMessage(), e);
			return errorResponse.setExceptionResponse(e);
		}
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUsers() {
		List<UsersRequest> usersList;

		try {
			usersList = usersService.getUsers();
			return Optional.ofNullable(usersList).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			log.error("Exception while fetching users ", e, e.getMessage());
			return errorResponse.setExceptionResponse(e);
		}
	}

	@PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchUsers(@RequestBody UsersRequest usersRequest) {
		List<UsersRequest> usersList;

		try {
			usersList = usersService.searchUsers(usersRequest);
			return Optional.ofNullable(usersList).map(u -> new ResponseEntity<>(u, HttpStatus.OK))
					.orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
		} catch (Exception e) {
			log.error("Exception while searching users ", e);
			return errorResponse.setExceptionResponse(e);
		}
	}
	@GetMapping(value = "/test")
	public String check() {
		return "tested";
	}
}
