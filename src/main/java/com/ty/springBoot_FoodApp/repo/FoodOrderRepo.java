package com.ty.springBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_FoodApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer>{

}
