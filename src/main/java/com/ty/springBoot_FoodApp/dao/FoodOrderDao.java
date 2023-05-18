package com.ty.springBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepo repo;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return repo.save(foodOrder);
	}

	public FoodOrder updateFoodOrder(int id, FoodOrder foodOrder) {
		Optional<FoodOrder> foodOrder2 = repo.findById(id);
		if (foodOrder2.isPresent()) {
			foodOrder.setFid(id);
			foodOrder.setItems(foodOrder.getItems());
			repo.save(foodOrder);
			return foodOrder2.get();
		} else {
			return null;
		}
	}

	public FoodOrder deleteFoodOrder(int id) {
		Optional<FoodOrder> order = repo.findById(id);
		if (order.isPresent()) {
			repo.deleteById(id);
			return order.get();
		} else {
			return null;
		}
	}

	public FoodOrder getOrderById(int id) {
		Optional<FoodOrder> order = repo.findById(id);
		if (order.isPresent()) {
			return order.get();
		} else {
			return null;
		}
	}
	
	public FoodOrder getFoodOrder(int id) {
		Optional<FoodOrder> foodOrder=repo.findById(id);
		if(foodOrder.isPresent()) {
			return foodOrder.get();
		}else {
			return null;
		}
	}
}
