package com.ty.springBoot_FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.springBoot_FoodApp.dto.Product;
import com.ty.springBoot_FoodApp.repo.ProductRepo;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepo repo;
	
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	
	public Product updateProduct(int id,Product product) {
		Optional<Product> product2= repo.findById(id);
		if(product2.isPresent()) {
			product.setPid(id);
			repo.save(product);
			return product2.get();
		}else {
			return null;
		}
	}
	
	public Product deleteProduct(int id) {
		Optional<Product> product = repo.findById(id);
		if(product.isPresent()) {
			repo.deleteById(id);
			return product.get();
		}else {
			return null;
		}
	}
	
	public Product getProductById(int id) {
		Optional<Product> product=repo.findById(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			return null;
		}
	}
	
	public List<Product> getAllProduct(){
		return repo.findAll();
	}
}
