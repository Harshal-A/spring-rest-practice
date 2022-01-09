package com.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.restfulwebservices.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
