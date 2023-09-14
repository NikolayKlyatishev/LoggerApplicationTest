package ru.nklyatyshev.logger.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

@Slf4j
@Component
public class LoggingUtil {
    public static void tryLogRequestIds(String method) {
        var requestId = RequestContextHolder.currentRequestAttributes()
                .getAttribute("requestId", 0);
        var parentRequestId = RequestContextHolder.currentRequestAttributes()
                .getAttribute("parentRequestId", 0);

        if (requestId != null) log.info("[{}]: RequestId: {}", method, requestId);
        if (parentRequestId != null) log.info("[{}]: ParentRequestId: {}", method, parentRequestId);
    }
}
