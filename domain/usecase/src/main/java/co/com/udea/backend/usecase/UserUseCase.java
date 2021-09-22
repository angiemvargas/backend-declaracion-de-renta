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
    public Mono<User> updateUser(User user){
        return userGateway.updateUser(user);
    }

    public User findByEmail(String email){
        return userGateway.findByEmail(email);
    }

    private void validateId(User user){

    }

    private void validateSocialRedId(){

    }

    private void validateIdentification(User user){

    }

    private void validatePersonalInformation(User user){

    }
}
