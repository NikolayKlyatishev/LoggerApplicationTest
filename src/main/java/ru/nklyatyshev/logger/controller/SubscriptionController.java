package ru.nklyatyshev.logger.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.nklyatyshev.logger.api.resourceApi.SubscriptionApi;
import ru.nklyatyshev.logger.model.SubscriptionEntity;
import ru.nklyatyshev.logger.service.mspsubscription.SubscriptionService;
import ru.nklyatyshev.logger.util.LoggingUtil;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SubscriptionController implements SubscriptionApi {

    private final SubscriptionService subscriptionService;

    @Override
    public SubscriptionEntity getResource(UUID id) {
        if (true) throw new RuntimeException("ERROR!!!");
        LoggingUtil.tryLogRequestIds("getSubscription");
        return subscriptionService.getBtId(id);
    }

    @Override
    public void deleteResource(UUID id) {
        LoggingUtil.tryLogRequestIds("deleteSubscription");
        log.info("Subscription {} was deleted", id);
    }

    @Override
    public UUID saveOrUpdateResource(SubscriptionEntity id) {
        LoggingUtil.tryLogRequestIds("saveOrUpdateSubscription");
        log.info("Subscription {} was updated", id);
        return UUID.randomUUID();
    }
}
