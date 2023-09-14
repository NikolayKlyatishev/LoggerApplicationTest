package ru.nklyatyshev.logger.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class SubscriptionDto extends Entity<UUID, SubscriptionDto.MspSubscriptionSqlQueryProvider> {
    private UUID createdByUserId;
    private Instant createdAt;
    private Boolean deleted;
    private SubscriptionStatus status;
    private Integer cloudId;
    private UUID customerId;
    private UUID applicationRequestId;
    private Instant startAt;
    private String name;
    private Boolean restricted;

    public static class MspSubscriptionSqlQueryProvider extends SQlEntityProvider {

        private final static String TABLE_NAME = "msp_subscription";
        private final static String UUID = "uuid";

        @Override
        public String getSchemaName() {
            return "dwh";
        }

        @Override
        public String getTableName() {
            return TABLE_NAME;
        }

        @Override
        public String getIdFieldName() {
            return UUID;
        }
    }
}
