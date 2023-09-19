package ru.nklyatyshev.logger.api.resourceApi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.nklyatyshev.logger.api.CrudApi;
import ru.nklyatyshev.logger.model.SubscriptionEntity;

import java.util.UUID;

public interface SubscriptionApi extends CrudApi<UUID, SubscriptionEntity> {

    @GetMapping("/subscription/{id}")
    SubscriptionEntity getResource(@PathVariable UUID id);

    @DeleteMapping("/subscription/{id}")
    void deleteResource(@PathVariable UUID id);

    @PostMapping("subscription")
    UUID saveOrUpdateResource(SubscriptionEntity subscription);
}
