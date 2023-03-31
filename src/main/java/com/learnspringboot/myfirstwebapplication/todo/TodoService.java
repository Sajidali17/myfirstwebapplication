package com.learnspringboot.myfirstwebapplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "root","Learn AWS",
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "root","Learn DevOps",
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "root","Learn Full Stack",
				LocalDate.now().plusYears(3), false));		
	}
	
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo> predicate = 
				todo -> todo.getUsername().equalsIgnoreCase(username);
				todos.stream().forEach(i->System.out.println(i));
		return todos.stream().filter(predicate).toList();
	//return todos;
	}
	
	public void addTodo(String username, String description,
			LocalDate targetdate, boolean done) {
		Todo todo = new Todo(++todosCount,username, description, targetdate, done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		todos.removeIf(predicate );
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodoService(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

}
