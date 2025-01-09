package com.jack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.entities.Todo;
import com.jack.exception.ResourceNotFoundException;
import com.jack.repository.TodoRepo;

@Service

public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepo todoRepo;
	
	@Override
	public Todo saveTodo(Todo todo) {
		
		return todoRepo.save(todo);
	}

	@Override
	public List<Todo> getAllTodo() {
		return todoRepo.findAll();
	}

	@Override
	public Todo getById(int id) 
	{
		return todoRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo id is not found " + id));

	}

	@Override
	public void deleteTodo(int id) {
		Todo todo=todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo id is not found "+id));
		if(todo != null) {
			todoRepo.delete(todo);
		}
		
	}

	@Override
	public Todo UpdateTodo(int id, Todo todo) {
		
		Todo oldtodo=todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo id is not found "+id));
		
		oldtodo.setTitle(todo.getTitle());
		oldtodo.setDescription(todo.getDescription());
		oldtodo.setStatus(todo.getStatus());

		oldtodo.setUsername(todo.getUsername());

		
			return todoRepo.save(oldtodo);
		
	}

}
