package com.minsu.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	/*
	private final TodoRepository todoRepository;
	
	public TodoController (TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	} = 해당 문법이 위의 Autowired로 선언하는것과 완전히 같은 기능*/
	
	//모든 할일(todo) 리스트 조회
	@GetMapping
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}
		
	// 할일(todo) 추가
	@PostMapping
	public Todo addTodo(@RequestBody Todo todo) {
		return todoRepository.save(todo);
	}
		
	// 할일(todo) 삭제->id를 전달 받아 삭제
	@DeleteMapping("/{id}") //삭제할 todo id
	public void deleteTodo(@PathVariable("id") Long id) {
		todoRepository.deleteById(id); //id로 조회하여 해당 레코드 삭제
	}
}
