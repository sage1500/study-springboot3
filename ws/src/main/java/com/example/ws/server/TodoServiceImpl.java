package com.example.ws.server;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class TodoServiceImpl implements TodoService {

    @Override
    public Todo getTodo(@NotNull String todoId) {
        var todo = new Todo();
        todo.setTodoId("1");
        todo.setTitle("todo1");
        return todo;
    }

    @Override
    public Todo createTodo(@Valid Todo todo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Todo updateTodo(@Valid Todo todo) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
