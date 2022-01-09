package com.webservices.restfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.restfulwebservices.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
