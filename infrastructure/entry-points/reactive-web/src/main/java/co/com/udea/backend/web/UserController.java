package co.com.udea.backend.web;

import co.com.udea.backend.model.entities.User;
import co.com.udea.backend.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/update")
    public Mono<User> updateUser(@RequestBody User user){
        return userUseCase.updateUser(user);
    }
}
