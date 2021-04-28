package co.com.udea.backend.web;

import co.com.udea.backend.model.entities.User;
import co.com.udea.backend.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="/api")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping("/create")
    public Mono<User> createUser(@RequestBody User user){
        return userUseCase.createUser(user);
    }
}
