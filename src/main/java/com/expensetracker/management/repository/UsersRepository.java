package com.expensetracker.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.management.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	public List<Users> findByUserId(Long userId);

	public List<Users> findByUserName(String userName);

	public List<Users> findByUserNameAndEmail(String userName, String email);

	public List<Users> findByEmail(String email);

}
