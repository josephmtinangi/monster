package io.github.josephmtinangi.monster.events;

import org.springframework.context.ApplicationEvent;

public class UserRegistered extends ApplicationEvent {


    private String message;

    public UserRegistered(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
