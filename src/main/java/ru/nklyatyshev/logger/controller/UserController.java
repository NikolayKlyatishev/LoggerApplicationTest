package ru.nklyatyshev.logger.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.nklyatyshev.logger.api.resourceApi.UserApi;
import ru.nklyatyshev.logger.model.UserDto;
import ru.nklyatyshev.logger.util.LoggingUtil;

import java.util.UUID;

@RestController
public class UserController implements UserApi {

    @Override
    public UserDto getResource(UUID id) {
        LoggingUtil.tryLogRequestIds("getUser");
        return new UserDto(1, "Jane", 41);
    }

    @Override
    public void deleteResource(UUID id) {
        LoggingUtil.tryLogRequestIds("deleteUser");

    }

    @Override
    public UUID saveOrUpdateResource(UserDto resource) {
        LoggingUtil.tryLogRequestIds("saveOrUpdateUser");
        return null;
    }
}
