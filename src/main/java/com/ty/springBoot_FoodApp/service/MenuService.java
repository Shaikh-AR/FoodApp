package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.Exception.MenuIdNotFoundException;
import com.ty.springBoot_FoodApp.Exception.ProductIdNotFoundException;
import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.MenuDao;
import com.ty.springBoot_FoodApp.dto.Menu;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Menu Successfully Saved");
		responseStructure.setData(dao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int id, Menu menu) {
		Menu menu2 = dao.updateMenu(id, menu);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Menu Succesfully Update");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFoundException("Menu id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int mid) {
		Menu menu = dao.deleteMenu(mid);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Menu Succefullly Deleted");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new MenuIdNotFoundException("Menu id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int mid) {
		Menu menu = dao.getMenuById(mid);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		if (menu != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Menu Succefullly Found");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new MenuIdNotFoundException("Menu id is not found");
		}
	}

}
