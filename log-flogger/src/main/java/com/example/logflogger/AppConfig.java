package com.example.logflogger;

import com.google.common.flogger.FluentLogger;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static com.google.common.flogger.LazyArgs.lazy;

@Configuration
public class AppConfig {
    private static final FluentLogger LOG = FluentLogger.forEnclosingClass();

    @PostConstruct
    public void init() {
        LOG.atInfo().atMostEvery(1, TimeUnit.SECONDS).log("Looping %s", lazy(() -> ThreadLocalRandom.current().doubles()));

    }
}
