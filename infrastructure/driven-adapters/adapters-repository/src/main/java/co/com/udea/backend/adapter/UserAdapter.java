package co.com.udea.backend.adapter;

import co.com.udea.backend.model.entities.User;
import co.com.udea.backend.model.gateway.UserGateway;
import co.com.udea.backend.mysql.dtos.UserData;
import co.com.udea.backend.mysql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserAdapter implements UserGateway {

    private final UserRepository userRepository;

    @Override
    public Mono<User> createUser(User user) {
        UserData userData = mapperDtoToData(user);
        return Mono.just(userRepository.save(userData))
                .flatMap(userData1 -> mapperDataToDto(userData));
    }

    private UserData mapperDtoToData(User user){
        UserData userData = new UserData();
        userData.setFacebookId(user.getFacebookId());
        userData.setGoogleId(user.getGoogleId());
        userData.setEmail(user.getEmail());
        userData.setFirstName(user.getFirstName());
        userData.setLastName(user.getLastName());
        userData.setDocumentId(user.getDocumentId());
        userData.setDocumentType(user.getDocumentType());
        return userData;
    }

    private Mono<User> mapperDataToDto(UserData userData){
        return Mono.just(User.builder()
                .facebookId(userData.getFacebookId())
                .googleId(userData.getGoogleId())
                .email(userData.getEmail())
                .firstName(userData.getFirstName())
                .lastName(userData.getLastName())
                .documentId(userData.getDocumentId())
                .documentType(userData.getDocumentType())
                .build());
    }
}
