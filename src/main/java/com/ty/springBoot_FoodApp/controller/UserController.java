package com.ty.springBoot_FoodApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.User;
import com.ty.springBoot_FoodApp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;

	/*
	 * IF YOU @VALID FROM JAVAX.VALIDATION THEN THE CLASS MUST BE VALIDATED ALL
	 * THING
	 * 
	 * @VALID USED TO VALIDATE THE CONDITION IN THAT CLASS
	 */

	@ApiOperation(value = "save user", notes = "API is used to save user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "suceessfully saved"),
			@ApiResponse(code = 400, message = "id not found for the given user") })
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}

	@ApiOperation(value = "Update user", notes = "API is used to Update user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "suceessfully Update"),
			@ApiResponse(code = 400, message = "id not found for the given user") })
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@Valid @RequestParam int id, @RequestBody User user) {
		return service.updateUser(id, user);
	}

	/*
	 * by using @PathVariable We must 1st do the RequestMapping in top after the
	 * RestControll
	 */

	@ApiOperation(value = "Delete user", notes = "API is used to delete user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "suceessfully deleted"),
			@ApiResponse(code = 400, message = "id not found for the given user") })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@Valid @PathVariable int id) {
		return service.deleteUser(id);
	}

	@ApiOperation(value = "Get user By Id", notes = "API is used to get the user for given user id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "user id is found "),
			@ApiResponse(code = 400, message = "id not found for the given user") })
	@GetMapping("/getuserbyid")
	public ResponseEntity<ResponseStructure<User>> getUserById(@Valid int id) {
		return service.getUserById(id);
	}
}
