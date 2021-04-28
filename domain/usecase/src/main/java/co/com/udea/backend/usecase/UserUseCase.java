package co.com.udea.backend.usecase;

import co.com.udea.backend.model.entities.User;
import co.com.udea.backend.model.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserGateway userGateway;

    public Mono<User> createUser(User user){
        return userGateway.createUser(user);
    }

    public void validateId(User user){

    }

    public void validateIdentification(User user){

    }

    public void validatePersonalInformation(User user){

    }
}
