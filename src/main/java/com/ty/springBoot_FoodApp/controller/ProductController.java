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
import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@ApiOperation(value = "save product", notes = "API is used to save product for given product id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "suceessfully saved"),
			@ApiResponse(code = 400, message = "id not found for the given product") })
	@PostMapping("/saveProduct")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@ApiOperation(value = "Update product", notes = "API is used to Update product for given product id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "suceessfully Update"),
			@ApiResponse(code = 400, message = "id not found for the given product") })
	@PutMapping("/updateProduct")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestParam int id,
			@RequestBody Product product) {
		return service.updateProduct(id, product);
	}

	@ApiOperation(value = "Delete product", notes = "API is used to delete product for given product id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "suceessfully deleted"),
			@ApiResponse(code = 400, message = "id not found for the given product") })
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int id) {
		return service.deleteProduct(id);
	}

	@ApiOperation(value = "Get product By Id", notes = "API is used to get the product for given product id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "product id is found "),
			@ApiResponse(code = 400, message = "id not found for the given product") })
	@GetMapping("/getProductbyid")
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		return service.getProductById(id);
	}
}
