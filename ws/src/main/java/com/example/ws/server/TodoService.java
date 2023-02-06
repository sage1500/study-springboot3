package com.example.ws.server;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

@Validated
public interface TodoService {

    Todo getTodo(@NotNull String todoId);

    Todo createTodo(@Valid Todo todo);

    @Validated({ Default.class, Todo.Update.class })
    Todo updateTodo(@Valid Todo todo);

}