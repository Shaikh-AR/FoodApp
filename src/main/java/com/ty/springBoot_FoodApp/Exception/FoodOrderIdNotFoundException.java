package com.ty.springBoot_FoodApp.Exception;

public class FoodOrderIdNotFoundException extends RuntimeException{
private String message = "id not found";
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public FoodOrderIdNotFoundException(String message) {
		this.message=message;
	}
}
