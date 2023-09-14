package ru.nklyatyshev.logger.client;

import org.springframework.cloud.openfeign.FeignClient;
import ru.nklyatyshev.logger.api.resourceApi.UserApi;

@FeignClient(name = "user", url = "http://localhost:8080/myApplication/")
public interface UserClient extends UserApi {

}
