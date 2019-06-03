package com.example.springevents.event;

import com.example.springevents.event.SpringEventPublisher;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.*;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.context.support.RequestHandledEvent;

@Configuration
@Log4j2
public class SpringEventsConfig {

    @Autowired
    private SpringEventPublisher publisher;

    @Bean
    public ApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();

        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }


    @EventListener
    public void go(ContextRefreshedEvent cse) {
        log.info("Go: " + cse.getSource().getClass().getSimpleName());
        publisher.fire("Handling context initialized or refreshed event.");
    }

    /**
     * Start is always explicit
     * So, if you want to get ContextStartedEvent, you should call start() on ApplicationContext.
     *
     * @param cse
     */
    @EventListener
    public void start(ContextStartedEvent cse) {
        log.info("Start: " + cse.getSource().getClass().getSimpleName());
        publisher.fire("Handling context started event.");
    }

    @EventListener
    public void stop(ContextStoppedEvent cse) {
        log.info("Stop: " + cse.getSource().getClass().getSimpleName());
        publisher.fire("Handling context stopped event.");
    }


    @EventListener
    public void close(ContextClosedEvent cse) {
        log.info("Close: " + cse.getSource().getClass().getSimpleName());
        publisher.fire("Handling context stopped event.");
    }

    /**
     * A web-specific event telling all beans that an HTTP request has been serviced.
     * This event is published after the request is complete.
     * This event is only applicable to web applications using Spring’s DispatcherServlet.
     * @param cse
     */
    @EventListener
    public void request(RequestHandledEvent cse) {
        log.info("Request: " + cse.getDescription());
        publisher.fire("Handling context stopped event.");
    }
}
