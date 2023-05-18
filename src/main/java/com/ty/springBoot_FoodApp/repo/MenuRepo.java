package com.ty.springBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_FoodApp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer>{

}
