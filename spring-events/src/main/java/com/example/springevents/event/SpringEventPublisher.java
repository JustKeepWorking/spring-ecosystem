package com.example.springevents.event;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SpringEventPublisher {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void fire(final String message) {
        log.info("Begin fire event: " + message);

        final SpringEvent event = new SpringEvent(this, message);
        this.publisher.publishEvent(event);

        log.info("Completed fire event: " + message);
    }


}
