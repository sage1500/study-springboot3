package com.example.ws.server;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class Todo implements Serializable {

    @Null(groups = Create.class)
    @NotNull(groups = Update.class)
    private String todoId;
    
    @NotNull
    private String title;

    private String description;
    private boolean finished;

    @Null(groups = Create.class)
    private Date createdAt;

    public interface Create {
    }

    public interface Update {
    }

}
