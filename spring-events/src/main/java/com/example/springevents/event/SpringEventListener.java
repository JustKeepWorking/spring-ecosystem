package com.example.springevents.event;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class SpringEventListener implements ApplicationListener<SpringEvent> {
    @Override
    public void onApplicationEvent(SpringEvent event) {
        log.info("Receive: " + event);
    }


}
