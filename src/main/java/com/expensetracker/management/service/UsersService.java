package com.expensetracker.management.service;

import java.util.List;

import com.expensetracker.management.dto.UsersRequest;

public interface UsersService {

	public UsersRequest saveOrUpdateUsers(UsersRequest usersRequest);

	public List<UsersRequest> getUsers();

	public List<UsersRequest> searchUsers(UsersRequest usersRequest);

	public List<UsersRequest> saveOrUpdateUsersList(List<UsersRequest> usersRequests);

}
