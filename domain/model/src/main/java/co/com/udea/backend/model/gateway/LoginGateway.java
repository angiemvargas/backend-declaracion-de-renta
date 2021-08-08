package co.com.udea.backend.model.gateway;

public interface LoginGateway {

    Boolean validateGoogle(String idTokenString);
    Boolean validateFacebook(String idTokenString);
}
