package com.ty.springBoot_FoodApp.Exception;

public class MenuIdNotFoundException extends RuntimeException{
private String message = "id not found";
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public MenuIdNotFoundException(String message) {
		this.message=message;
	}
}
