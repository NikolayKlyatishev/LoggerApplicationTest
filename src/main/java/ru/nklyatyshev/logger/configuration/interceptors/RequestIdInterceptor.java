package ru.nklyatyshev.logger.configuration.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

public class RequestIdInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        MDC.clear();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var parentRequestId = request.getHeader("requestId");
        var requestId = UUID.randomUUID().toString();

        RequestContextHolder.currentRequestAttributes().setAttribute("requestId", requestId, 0);
        if (parentRequestId != null)
            RequestContextHolder.currentRequestAttributes().setAttribute("parentRequestId", parentRequestId, 0);

        MDC.put("requestId", requestId);
        MDC.put("parentRequestId", parentRequestId);
        return true;
    }
}
