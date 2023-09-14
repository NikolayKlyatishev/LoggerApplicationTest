package ru.nklyatyshev.logger.dao;

import org.apache.ibatis.annotations.SelectProvider;
import ru.nklyatyshev.logger.model.SubscriptionDto;

import java.util.UUID;

public interface SubscriptionDao {

    @SelectProvider(type = SubscriptionDto.MspSubscriptionSqlQueryProvider.class, method = "selectById")
    SubscriptionDto findById(UUID id);

    @SelectProvider(type = SubscriptionDto.MspSubscriptionSqlQueryProvider.class, method = "deleteById")
    SubscriptionDto deleteById(UUID id);

    void save(SubscriptionDto mspSubscription);

    void update(SubscriptionDto mspSubscription);
}
