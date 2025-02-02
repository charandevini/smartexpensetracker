package com.expensetracker.management.service;

import com.expensetracker.management.dto.UsersRequest;

public interface UsersService {

	public UsersRequest saveOrUpdateUsers(UsersRequest usersRequest);

}
