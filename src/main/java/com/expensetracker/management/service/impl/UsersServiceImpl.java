package com.expensetracker.management.service.impl;

import org.springframework.stereotype.Service;

import com.expensetracker.management.dto.UsersRequest;
import com.expensetracker.management.mapper.UsersMapper;
import com.expensetracker.management.model.Users;
import com.expensetracker.management.repository.UsersRepository;
import com.expensetracker.management.service.UsersService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

	private UsersMapper usersMapper;
	private UsersRepository usersRepository;

	@Override
	public UsersRequest saveOrUpdateUsers(UsersRequest usersRequest) {
		Users users = usersMapper.usersRequestToEntity(usersRequest);
		return usersMapper.usersEntityToRequest(usersRepository.save(users));
	}

}
