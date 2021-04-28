package co.com.udea.backend;

import co.com.udea.backend.model.gateway.UserGateway;
import co.com.udea.backend.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserControllerConfig {

    @Bean
    public UserUseCase userUseCase(UserGateway userGateway){
        return new UserUseCase(userGateway);
    }
}
