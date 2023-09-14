package ru.nklyatyshev.logger.api.resourceApi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.nklyatyshev.logger.api.CrudApi;
import ru.nklyatyshev.logger.model.UserDto;

import java.util.UUID;

public interface UserApi extends CrudApi<UUID, UserDto> {

    @GetMapping("/user/{id}")
    UserDto getResource(@PathVariable UUID id);

    @DeleteMapping("/user/{id}")
    void deleteResource(@PathVariable UUID id);

    @PostMapping("/user")
    UUID saveOrUpdateResource(@RequestBody UserDto resource);
}
