package com.expensetracker.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensetracker.management.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
