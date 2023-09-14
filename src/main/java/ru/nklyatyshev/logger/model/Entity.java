package ru.nklyatyshev.logger.model;

import lombok.Data;

@Data
public abstract class Entity<T, PROVIDER extends Entity.SQlEntityProvider> {

    private T id;

    public abstract static class SQlEntityProvider {

        public abstract String getSchemaName();

        public abstract String getTableName();

        public abstract String getIdFieldName();

        public String selectById() {
            return " select " + getIdFieldName() + " as id, * from " + getSchemaName() + "." + getTableName() +
                    " where " + getIdFieldName() + " = " + "'${id}'; ";
        }

        public String deleteById() {
            return " delete from " + getSchemaName() + "." + getTableName() +
                    " where " + getIdFieldName() + " = " + "'${id}'; ";
        }
    }
}
