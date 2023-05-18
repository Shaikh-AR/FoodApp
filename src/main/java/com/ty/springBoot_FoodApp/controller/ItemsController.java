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
import com.ty.springBoot_FoodApp.dto.Items;
import com.ty.springBoot_FoodApp.service.ItemsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemsController {
	@Autowired
	private ItemsService service;

	@ApiOperation(value = "save item",notes = "API is used to save item for given item id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "suceessfully saved"),
						@ApiResponse(code=400,message = "id not found for the given item")})
	@PostMapping("/saveItem")
	public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items) {
		return service.saveItems(items);
	}

	@ApiOperation(value = "Update item",notes = "API is used to Update item for given item id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "suceessfully Update"),
						@ApiResponse(code=400,message = "id not found for the given item")})
	@PutMapping("/updateItem")
	public ResponseEntity<ResponseStructure<Items>> updateItem(@RequestParam int id, @RequestBody Items items) {
		return service.updateItem(id, items);
	}

	@ApiOperation(value = "Delete item",notes = "API is used to delete item for given item id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "suceessfully deleted"),
						@ApiResponse(code=400,message = "id not found for the given item")})
	@DeleteMapping("/deleteItem")
	public ResponseEntity<ResponseStructure<Items>> deleteItem(@RequestParam int id) {
		return service.deleteItem(id);
	}

	@ApiOperation(value = "Get item By Id",notes = "API is used to get the item for given item id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "item id is found "),
			@ApiResponse(code = 400, message = "id not found for the given item")})
	@GetMapping("/getItemById")
	public ResponseEntity<ResponseStructure<Items>> getItemById(@RequestParam int id) {
		return service.getItemById(id);
	}
}
