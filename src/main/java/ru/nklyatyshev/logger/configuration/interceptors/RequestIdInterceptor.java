package ru.nklyatyshev.logger.configuration.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Slf4j
public class RequestIdInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var parentRequestId = request.getHeader("requestId");
        var requestId = UUID.randomUUID().toString();

        RequestContextHolder.currentRequestAttributes().setAttribute("requestId", requestId, 0);
        if (parentRequestId != null)
            RequestContextHolder.currentRequestAttributes().setAttribute("parentRequestId", parentRequestId, 0);

        return true;
    }
}
