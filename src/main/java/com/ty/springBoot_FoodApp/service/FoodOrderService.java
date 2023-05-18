package com.ty.springBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.Exception.FoodOrderIdNotFoundException;
import com.ty.springBoot_FoodApp.Exception.ItemsIdNotFoundException;
import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.FoodOrderDao;
import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.dto.Items;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao dao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		List<Items> list = foodOrder.getItems();
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		double totalprice = 0;
		for (Items items : list) {
			totalprice += items.getCost() * items.getQuantity();
			foodOrder.setTotalprice(totalprice);
		}
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("FoodOrder Successfully Saved");
		responseStructure.setData(dao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(int id, FoodOrder foodOrder) {
		FoodOrder foodOrder2 = dao.getFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (foodOrder2 != null) {
			List<Items> list = foodOrder2.getItems();
			double totalprice = 0;
			for (Items items : list) {
				totalprice += items.getCost() * items.getQuantity();
			}
			foodOrder.setTotalprice(totalprice);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("FoodOrder Succesfully Update");
			responseStructure.setData(dao.updateFoodOrder(id, foodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFoundException("FoodOrder id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		FoodOrder order = dao.deleteFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (order != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("FoodOrder Succefullly Deleted");
			responseStructure.setData(order);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		} else {
			throw new FoodOrderIdNotFoundException("FoodOrder id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getOrderById(int id) {
		FoodOrder order = dao.getOrderById(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (order != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("FoodOrder Succefullly Found");
			responseStructure.setData(order);

			// if price not show then uncomment this thing it will be work properly
//			List<Items> list = foodOrder2.getItems();
//			double totalprice = 0;
//			for (Items items : list) {
//				totalprice += items.getCost() * items.getQuantity();
//			}
//			Order.setTotalprice(totalprice);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new FoodOrderIdNotFoundException("Food Order id is not Found");
		}
	}
}
