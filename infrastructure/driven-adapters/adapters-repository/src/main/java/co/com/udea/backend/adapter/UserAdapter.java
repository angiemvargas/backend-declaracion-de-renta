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

    @Override
    public Mono<User> updateUser(User user) {
        return Mono.just(userRepository.findById(user.getId()).get())
                .flatMap(userData -> setInformation(user, userData))
                .flatMap(userUpdate -> Mono.just(userRepository.save(userUpdate)))
                .thenReturn(user);
    }

    private Mono<UserData> setInformation(User user, UserData userData){
        userData.setPhonenumber(user.getPhoneNumber());
        userData.setRole(user.getRole());
        return Mono.just(userData);
    }

    private UserData mapperDtoToData(User user){
        UserData userData = new UserData();
        userData.setFacebookid(user.getFacebookId());
        userData.setGoogleid(user.getGoogleId());
        userData.setEmail(user.getEmail());
        userData.setFirstname(user.getFirstName());
        userData.setLastname(user.getLastName());
        userData.setDocumentid(user.getDocumentId());
        userData.setDocumenttype(user.getDocumentType());
        return userData;
    }

    private Mono<User> mapperDataToDto(UserData userData){
        return Mono.just(User.builder()
                .facebookId(userData.getFacebookid())
                .googleId(userData.getGoogleid())
                .email(userData.getEmail())
                .firstName(userData.getFirstname())
                .lastName(userData.getLastname())
                .documentId(userData.getDocumentid())
                .documentType(userData.getDocumenttype())
                .build());
    }
}
