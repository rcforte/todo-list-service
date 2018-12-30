package com.rcforte.todolistservice;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo-list/")
@Log
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
    log.info("save: " + todoList);
    return repo.save(todoList);
  }
}
