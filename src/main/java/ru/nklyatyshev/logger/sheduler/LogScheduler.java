package ru.nklyatyshev.logger.sheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class LogScheduler {

//    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void writeInfoLog() {
        log.debug("Debug log of scheduler");
        log.info("Info log of scheduler");
        log.warn("Warn log of scheduler");
        log.warn("Error log of scheduler");
        throw new RuntimeException("StackTrace log of scheduler");
    }
}
