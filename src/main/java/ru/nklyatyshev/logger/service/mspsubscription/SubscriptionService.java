package ru.nklyatyshev.logger.service.mspsubscription;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.nklyatyshev.logger.client.UserClient;
import ru.nklyatyshev.logger.dao.SubscriptionDao;
import ru.nklyatyshev.logger.model.SubscriptionDto;

import java.util.UUID;

import static java.util.Objects.isNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionDao mspSubscriptionDao;
    private final UserClient userClient;

    public SubscriptionDto getBtId(UUID id) {
        var user = userClient.getResource(UUID.randomUUID());
        return mspSubscriptionDao.findById(id);
    }

    public SubscriptionDto delete(UUID id) {
        return mspSubscriptionDao.deleteById(id);
    }

    public void saveOrUpdate(SubscriptionDto mspSubscription) {
        if (isNull(mspSubscription.getId())) {
            mspSubscriptionDao.save(mspSubscription);
        } else {
            mspSubscriptionDao.update(mspSubscription);
        }
    }
}