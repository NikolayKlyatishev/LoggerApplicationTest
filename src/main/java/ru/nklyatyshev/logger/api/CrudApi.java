package ru.nklyatyshev.logger.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudApi<ID, DTO> {

    @GetMapping("{id}")
    DTO getResource(@PathVariable ID id);

    @DeleteMapping("{id}")
    void deleteResource(@PathVariable ID id);

    @PostMapping
    ID saveOrUpdateResource(@RequestBody DTO resource);
}
