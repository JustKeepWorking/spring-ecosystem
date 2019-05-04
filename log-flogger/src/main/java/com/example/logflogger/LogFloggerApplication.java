package com.example.logflogger;

import com.google.common.flogger.FluentLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LogFloggerApplication {
    private static final FluentLogger LOG = FluentLogger.forEnclosingClass();

    public static void main(String[] args) {
        SpringApplication.run(LogFloggerApplication.class, args);
    }

    @PostConstruct
    public void setup() {
        LOG.atInfo().log("Log message with: %s", this.getClass().getSimpleName());
    }

}
