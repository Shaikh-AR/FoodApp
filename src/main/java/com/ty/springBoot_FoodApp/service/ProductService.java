package com.ty.springBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.springBoot_FoodApp.Exception.ProductIdNotFoundException;
import com.ty.springBoot_FoodApp.Exception.UserIdNotFoundException;
import com.ty.springBoot_FoodApp.config.ResponseStructure;
import com.ty.springBoot_FoodApp.dao.ProductDao;
import com.ty.springBoot_FoodApp.dto.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product Successfully Saved");
		responseStructure.setData(productDao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(int id, Product product) {
		Product product2 = productDao.updateProduct(id, product);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product Succesfully Update");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ProductIdNotFoundException("Product id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {
		Product product = productDao.deleteProduct(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Product Succefullly Deleted");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);

		} else {
			throw new ProductIdNotFoundException("Product id is not found");
		}
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {
		Product product = productDao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Product Succefullly Found");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ProductIdNotFoundException("Product id is not found");
		}
	}
}
