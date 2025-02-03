package com.expensetracker.management.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.expensetracker.management.dto.UsersRequest;
import com.expensetracker.management.model.Users;

@Mapper(componentModel = "spring")
public interface UsersMapper {

	UsersMapper MAPPER = Mappers.getMapper(UsersMapper.class);

	Users usersRequestToEntity(UsersRequest usersRequest);

	@Mapping(target = "password", ignore = true)
	UsersRequest usersEntityToRequest(Users users);

	default List<UsersRequest> usersListToRequestList(List<Users> users) {
		return users.stream().map(this::usersEntityToRequest).collect(Collectors.toList());
	}
}
