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
        new TodoList(null, "Breakfast todo",
            Lists.newArrayList(
                new TodoListItem(null, "Buy bread"),
                new TodoListItem(null, "Cook eggs")
            )
        ),
        new TodoList(null, "Lunch todo",
            Lists.newArrayList(
                new TodoListItem(null, "Buy steak"),
                new TodoListItem(null, "Cook steak")
            )
        ),
        new TodoList(null, "Dinner todo",
            Lists.newArrayList(
                new TodoListItem(null, "Buy fish"),
                new TodoListItem(null, "Cook fish")
            )
        )
    );
    todos.stream().forEach(repo::save);
  }
}

