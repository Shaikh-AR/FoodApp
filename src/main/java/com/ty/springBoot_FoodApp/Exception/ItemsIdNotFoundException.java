package com.ty.springBoot_FoodApp.Exception;

public class ItemsIdNotFoundException extends RuntimeException {
private String message = "id not found";
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public ItemsIdNotFoundException(String message) {
		this.message=message;
	}
}
