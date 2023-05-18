package com.ty.springBoot_FoodApp.Exception;

public class UserIdNotFoundException extends RuntimeException {
	private String message = "id not found";
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public UserIdNotFoundException(String message) {
		this.message=message;
	}
	
}
