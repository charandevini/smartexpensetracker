package com.expensetracker.management.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
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

	@Override
	public List<UsersRequest> getUsers() {
		List<Users> usersList = usersRepository.findAll();
		return usersMapper.usersListToRequestList(usersList);

	}

	@Override
	public List<UsersRequest> searchUsers(UsersRequest usersRequest) {
		List<UsersRequest> users = new ArrayList<>();
		List<Users> usersList = new ArrayList<>();

		if (usersRequest.getUserId() != null)
			usersList = usersRepository.findByUserId(usersRequest.getUserId());
		if (usersRequest.getUserName() != null)
			usersList = usersRepository.findByUserName(usersRequest.getUserName());
		if (usersRequest.getEmail() != null)
			usersList = usersRepository.findByEmail(usersRequest.getEmail());
		if (usersRequest.getUserName() != null && usersRequest.getEmail() != null)
			usersList = usersRepository.findByUserNameAndEmail(usersRequest.getUserName(), usersRequest.getEmail());

		if (CollectionUtils.isNotEmpty(usersList))
			users = usersMapper.usersListToRequestList(usersList);

		return users;

	}

	@Override
	public List<UsersRequest> saveOrUpdateUsersList(List<UsersRequest> usersRequestList) {
		List<UsersRequest> usersList = new ArrayList<>();

		for (UsersRequest usersRequest : usersRequestList) {
			usersList.add(saveOrUpdateUsers(usersRequest));
		}
		return usersList;
	}

}
