package ru.nklyatyshev.logger.configuration.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nklyatyshev.logger.configuration.mybatis.typeHandler.UuidTypeHandler;

import java.util.UUID;

@Configuration
@MapperScan("ru.nklyatyshev.logger.dao")
public class MyBatisConfiguration {

    @Bean
    ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            var typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            typeHandlerRegistry.register(UUID.class, UuidTypeHandler.class);
        };
    }
}
