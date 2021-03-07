package me.study.todolist.todo.service;

import me.study.todolist.todo.dto.TodoCreateDto;
import me.study.todolist.todo.dto.TodoUpdateDto;
import me.study.todolist.todo.entity.Todo;
import me.study.todolist.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(TodoCreateDto todoCreateDto) {

        Todo todo = new Todo(todoCreateDto.getTitle()
        , todoCreateDto.getDescription()
        , todoCreateDto.getDueDate());

        return todoRepository.save(todo);
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodo(Long id) {
        return todoRepository.findById(id);
    }

    public Todo updateTodo(Long id, TodoUpdateDto todoUpdateDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        todo.setTitle(todoUpdateDto.getTitle());
        todo.setDescription(todoUpdateDto.getDescription());
        todo.setDueDate(todoUpdateDto.getDueDate());
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
