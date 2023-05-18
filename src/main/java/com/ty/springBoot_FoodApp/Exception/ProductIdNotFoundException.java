package com.ty.springBoot_FoodApp.Exception;

public class ProductIdNotFoundException extends RuntimeException{
	
private String message = "id not found";
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public ProductIdNotFoundException(String message) {
		this.message=message;
	}
}
