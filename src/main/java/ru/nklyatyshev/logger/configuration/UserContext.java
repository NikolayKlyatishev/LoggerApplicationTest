package ru.nklyatyshev.logger.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class UserContext {
    private String userId = "123";
}
