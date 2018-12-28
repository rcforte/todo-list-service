package com.rcforte.todolistservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-list/")
public class TodoListController {

  private final TodoListRepository repo;

  public TodoListController(TodoListRepository repo) {
    this.repo = repo;
  }

  @GetMapping
  public List<TodoList> findAll() {
    return repo.findAll();
  }

  @PostMapping
  public TodoList save(@RequestBody TodoList todoList) {
    return repo.save(todoList);
  }
}
