package ru.nklyatyshev.logger.configuration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class UserContextProvider {

    @Getter
    private static UserContext userContext;

    public UserContextProvider(UserContext userContext) {
        UserContextProvider.userContext = userContext;
    }
}
