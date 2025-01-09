package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.entities.Todo;

public interface TodoRepo extends JpaRepository<Todo,Integer> {

}
