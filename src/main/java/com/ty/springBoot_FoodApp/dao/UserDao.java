package com.ty.springBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.repo.UserRepo;

@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User updateUser(int id,User user) {
		Optional<User> user2= repo.findById(id);
		if(user2.isPresent()) {
			user.setId(id);
			return repo.save(user);
		}else {
			return null;
		}
	}
	
	public User deleteUser(int id) {
		Optional<User> user = repo.findById(id);
		if(user.isPresent()) {
			repo.deleteById(id);
			return user.get();
		}else {
			return null;
		}
	}
	
	public User getUserById(int id) {
		Optional<User> user=repo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	
	public List<User> getAllUser(){
		return repo.findAll();
	}
}
