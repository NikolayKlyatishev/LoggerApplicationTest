package ru.nklyatyshev.logger.dao;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.SelectProvider;
import ru.nklyatyshev.logger.model.SubscriptionEntity;

import java.util.UUID;

public interface SubscriptionDao {

    @SelectProvider(type = SubscriptionEntity.MspSubscriptionSqlQueryProvider.class, method = "selectById")
    SubscriptionEntity findById(UUID id);

    @DeleteProvider(type = SubscriptionEntity.MspSubscriptionSqlQueryProvider.class, method = "deleteById")
    SubscriptionEntity deleteById(UUID id);

    void save(SubscriptionEntity mspSubscription);

    void update(SubscriptionEntity mspSubscription);
}
