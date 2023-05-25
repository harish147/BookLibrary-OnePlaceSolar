package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.entity.User;
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByLoginId(String loginId);
	
	public List<User> findAllByRole(String role);
	
}
