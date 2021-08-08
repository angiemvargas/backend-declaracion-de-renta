package co.com.udea.backend.adapter;

import co.com.udea.backend.externalservices.GoogleValidation;
import co.com.udea.backend.model.gateway.LoginGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Repository
@RequiredArgsConstructor
public class LoginAdapter implements LoginGateway {

    private final GoogleValidation googleValidation;

    @Override
    public Boolean validateGoogle(String idTokenString) {
        try {
            return googleValidation.validateGoogle(idTokenString);
        } catch (GeneralSecurityException | IOException e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean validateFacebook(String idTokenString) {
        return null;
    }
}
