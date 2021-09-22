package co.com.udea.backend.model.gateway;

import co.com.udea.backend.model.entities.User;
import reactor.core.publisher.Mono;

public interface UserGateway {

    Mono<User> createUser(User user);

    Mono<User> updateUser(User user);

    User findByEmail(String username);
}
