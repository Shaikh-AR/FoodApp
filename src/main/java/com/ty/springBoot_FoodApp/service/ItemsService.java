package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.Exception.ItemsIdNotFoundException;
import com.ty.springBoot_FoodApp.Exception.MenuIdNotFoundException;
import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.ItemsDao;
import com.ty.springBoot_FoodApp.dto.Items;

@Service
public class ItemsService {
	@Autowired
	private ItemsDao dao;

	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Item Successfully Saved");
		responseStructure.setData(dao.saveItem(items));
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Items>> updateItem(int id, Items items) {
		Items items2 = dao.updateItem(id, items);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Item Succesfully Update");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ItemsIdNotFoundException("Item id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<Items>> deleteItem(int id) {
		Items items = dao.deleteItem(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Item Succefullly Deleted");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ItemsIdNotFoundException("Item id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<Items>> getItemById(int id) {
		Items items = dao.getItemById(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Item Succefullly Found");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ItemsIdNotFoundException("Item id is not found");
		}
	}

}
