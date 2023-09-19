package ru.nklyatyshev.logger.service.mspsubscription;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nklyatyshev.logger.client.UserClient;
import ru.nklyatyshev.logger.dao.SubscriptionDao;
import ru.nklyatyshev.logger.model.SubscriptionEntity;

import java.util.UUID;

import static java.util.Objects.isNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionDao mspSubscriptionDao;
    private final UserClient userClient;

    public SubscriptionEntity getBtId(UUID id) {
        var user = userClient.getResource(UUID.randomUUID());
        return mspSubscriptionDao.findById(id);
    }

    public SubscriptionEntity delete(UUID id) {
        return mspSubscriptionDao.deleteById(id);
    }

    public void saveOrUpdate(SubscriptionEntity mspSubscription) {
        if (isNull(mspSubscription.getId())) {
            mspSubscriptionDao.save(mspSubscription);
        } else {
            mspSubscriptionDao.update(mspSubscription);
        }
    }
}