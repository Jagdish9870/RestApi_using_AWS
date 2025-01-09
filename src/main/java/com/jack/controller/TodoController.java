package com.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.entities.Todo;
import com.jack.service.TodoService;

@RestController
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	
	@PostMapping("/saveTodo")
	public ResponseEntity<?> save(@RequestBody Todo todo){
		return new ResponseEntity<>(todoService.saveTodo(todo),HttpStatus.CREATED);	
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(todoService.getAllTodo(),HttpStatus.OK);	
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getOne(@PathVariable int id){
		
		return new ResponseEntity<>(todoService.getById(id),HttpStatus.OK);	
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable int id){
		todoService.deleteTodo(id);
		return new ResponseEntity<>("todo deleted",HttpStatus.OK);	
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateTodo(@RequestBody Todo todo,@PathVariable int id){
		return new ResponseEntity<>(todoService.UpdateTodo(id,todo),HttpStatus.OK);	
	}
	
	
	

}
