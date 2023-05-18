package com.ty.springBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.springBoot_FoodApp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
