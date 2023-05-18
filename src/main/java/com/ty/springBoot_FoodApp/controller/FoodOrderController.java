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
import com.ty.springBoot_FoodApp.dto.FoodOrder;
import com.ty.springBoot_FoodApp.service.FoodOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FoodOrderController {

	@Autowired
	private FoodOrderService service;

	@ApiOperation(value = "save foodorder", notes = "API is used to save foodorder for given foodorder id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "suceessfully saved"),
			@ApiResponse(code = 400, message = "id not found for the given foodorder") })
	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return service.saveFoodOrder(foodOrder);
	}

	@ApiOperation(value = "Update foodorder", notes = "API is used to Update foodorder for given foodorder id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "suceessfully Update"),
			@ApiResponse(code = 400, message = "id not found for the given foodorder") })
	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestParam int id,
			@RequestBody FoodOrder foodOrder) {
		return service.updateFoodOrder(id, foodOrder);
	}

	@ApiOperation(value = "Delete foodorder", notes = "API is used to delete foodorder for given foodorder id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "suceessfully deleted"),
			@ApiResponse(code = 400, message = "id not found for the given foodorder") })
	@DeleteMapping("/deleteFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int id) {
		return service.deleteFoodOrder(id);
	}

	@ApiOperation(value = "Get foodorder By Id", notes = "API is used to get the foodorder for given foodorder id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "foodorder id is found "),
			@ApiResponse(code = 400, message = "id not found for the given foodorder") })
	@GetMapping("/getOrderById")
	public ResponseEntity<ResponseStructure<FoodOrder>> getOrderById(@RequestParam int id) {
		return service.getOrderById(id);
	}
}
