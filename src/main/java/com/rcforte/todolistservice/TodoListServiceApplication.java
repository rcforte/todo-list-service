package com.rcforte.todolistservice;

import com.google.common.collect.Lists;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class TodoListServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoListServiceApplication.class, args);
  }
}

@Component
class CLR implements CommandLineRunner {

  private final TodoListRepository repo;

  public CLR(TodoListRepository repo) {
    this.repo = repo;
  }

  @Override
  public void run(String... args) throws Exception {
    List<TodoList> todos = Lists.newArrayList(
        new TodoList(null, "Breakfast todo"),
        new TodoList(null, "Lunch todo"),
        new TodoList(null, "Dinner todo")
    );
    todos.stream().forEach(repo::save);
  }
}

