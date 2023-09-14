package ru.nklyatyshev.logger.api.resourceApi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.nklyatyshev.logger.api.CrudApi;
import ru.nklyatyshev.logger.model.SubscriptionDto;

import java.util.UUID;

public interface SubscriptionApi extends CrudApi<UUID, SubscriptionDto> {

    @GetMapping("/subscription/{id}")
    SubscriptionDto getResource(@PathVariable UUID id);

    @DeleteMapping("/subscription/{id}")
    void deleteResource(@PathVariable UUID id);

    @PostMapping("subscription")
    UUID saveOrUpdateResource(SubscriptionDto subscription);
}
