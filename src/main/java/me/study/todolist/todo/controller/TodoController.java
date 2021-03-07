package me.study.todolist.todo.controller;

import me.study.todolist.todo.dto.TodoCreateDto;
import me.study.todolist.todo.dto.TodoUpdateDto;
import me.study.todolist.todo.entity.Todo;
import me.study.todolist.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    private Todo createTodo(@Valid TodoCreateDto todoCreateDto) {
        return todoService.createTodo(todoCreateDto);
    }

    @GetMapping("/todos")
    private List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @GetMapping("/todos/{id}")
    private Optional<Todo> getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @PutMapping("/todos/{id}")
    private Todo updateTodo(@PathVariable Long id, TodoUpdateDto todoUpdateDto) {
        return todoService.updateTodo(id, todoUpdateDto);
    }

    @DeleteMapping("/todos/{id}")
    private void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
