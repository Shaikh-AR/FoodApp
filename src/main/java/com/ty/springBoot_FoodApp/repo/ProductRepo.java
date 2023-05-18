package com.ty.springBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_FoodApp.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
