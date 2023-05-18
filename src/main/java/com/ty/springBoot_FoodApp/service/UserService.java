package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.Exception.UserIdNotFoundException;
import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.UserDao;
import com.ty.springBoot_FoodApp.dto.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("User Successfully Saved");
		responseStructure.setData(dao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User user2 = dao.updateUser(id, user);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (user2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User Succesfully Update");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("User id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User user = dao.deleteUser(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User Succefullly Deleted");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("User id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		User user = dao.getUserById(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("User Succefullly Found");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new UserIdNotFoundException("User id is not found");
		}
	}
}
