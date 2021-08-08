package co.com.udea.backend.web;

import co.com.udea.backend.model.entities.Login;
import co.com.udea.backend.model.entities.User;
import co.com.udea.backend.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginUseCase loginUseCase;

    @PostMapping()
    public Mono<User> loginWithApp(@RequestBody Login login){
        return loginUseCase.loginWithApp(login);
    }
}
