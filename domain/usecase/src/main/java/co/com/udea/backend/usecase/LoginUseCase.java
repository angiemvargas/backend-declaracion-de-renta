package co.com.udea.backend.usecase;

import co.com.udea.backend.model.entities.Login;
import co.com.udea.backend.model.entities.User;
import co.com.udea.backend.model.gateway.LoginGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class LoginUseCase {

    private static final String GOOGLE = "google";
    private static final String FACEBOOK = "facebook";
    private final LoginGateway loginGateway;

    public Mono<User> loginWithApp(Login login) {

        Boolean validate = Boolean.FALSE;

        if(GOOGLE.equalsIgnoreCase(login.getApp())){
            validate = loginGateway.validateGoogle(login.getToken());
        }

        if(FACEBOOK.equalsIgnoreCase(login.getApp())){
            validate = loginGateway.validateFacebook(login.getToken());
        }

        return null;
    }
}
