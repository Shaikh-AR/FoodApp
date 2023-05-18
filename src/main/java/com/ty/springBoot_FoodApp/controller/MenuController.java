package com.ty.springBoot_FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dto.Menu;
import com.ty.springBoot_FoodApp.service.MenuService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MenuController {

	@Autowired
	private MenuService service;

	@ApiOperation(value = "save menu",notes = "API is used to save menu for given menu id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "suceessfully saved"),
						@ApiResponse(code=400,message = "id not found for the given menu")})
	@PostMapping("/saveMenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return service.saveMenu(menu);
	}

	@ApiOperation(value = "Update menu",notes = "API is used to Update menu for given menu id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "suceessfully Update"),
						@ApiResponse(code=400,message = "id not found for the given menu")})
	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int id, @RequestBody Menu menu) {
		return service.updateMenu(id, menu);
	}

	@ApiOperation(value = "Delete menu",notes = "API is used to delete menu for given menu id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "suceessfully deleted"),
						@ApiResponse(code=400,message = "id not found for the given menu")})
	@DeleteMapping("/deleteMenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int mid) {
		return service.deleteMenu(mid);
	}

	@ApiOperation(value = "Get menu By Id",notes = "API is used to get the menu for given menu id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "menu id is found "),
			@ApiResponse(code = 400, message = "id not found for the given menu")})
	@GetMapping("/getMenuById")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int mid) {
		return service.getMenuById(mid);
	}
}
