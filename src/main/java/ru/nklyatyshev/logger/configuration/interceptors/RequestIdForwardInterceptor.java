package ru.nklyatyshev.logger.configuration.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;

@Configuration
public class RequestIdForwardInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        var requestId = RequestContextHolder.currentRequestAttributes()
                .getAttribute("requestId", 0);

        if (requestId != null) template.header("requestId", requestId.toString());
    }
}
