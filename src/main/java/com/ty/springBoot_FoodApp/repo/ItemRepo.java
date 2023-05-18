package com.ty.springBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_FoodApp.dto.Items;

public interface ItemRepo extends JpaRepository<Items, Integer>{

}
