package com.example.springevents.event;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
public class SpringEvent extends ApplicationEvent {
    private String message;

    public SpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
