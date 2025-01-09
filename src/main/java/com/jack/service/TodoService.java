package com.jack.service;

import java.util.List;

import com.jack.entities.Todo;

public interface TodoService {
	public Todo saveTodo(Todo todo);
	public List<Todo> getAllTodo();
	public Todo getById(int id);
	public void deleteTodo(int id);
	public Todo UpdateTodo(int id,Todo todo);

}
