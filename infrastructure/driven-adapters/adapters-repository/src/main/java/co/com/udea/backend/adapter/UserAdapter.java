package co.com.udea.backend.adapter;

import co.com.udea.backend.model.entities.User;
import co.com.udea.backend.model.gateway.UserGateway;
import co.com.udea.backend.mysql.dtos.UserData;
import co.com.udea.backend.mysql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class UserAdapter implements UserGateway {

    private final UserRepository userRepository;

    @Override
    public Mono<User> createUser(User user) {
        UserData userData = mapperDtoToData(user);
        return Mono.just(userRepository.save(userData))
                .flatMap(userData1 -> Mono.just(mapperDataToDto(userData)));
    }

    @Override
    public Mono<User> updateUser(User user) {
        return Mono.just(userRepository.findById(user.getId()).get())
                .flatMap(userData -> setInformation(user, userData))
                .flatMap(userUpdate -> Mono.just(userRepository.save(userUpdate)))
                .thenReturn(user);
    }

    @Override
    public User findByEmail(String username) {
        UserData data =  userRepository.findByEmail(username);
        return Objects.nonNull(data) ? mapperDataToDto(data) : null;
    }

    private Mono<UserData> setInformation(User user, UserData userData){
        userData.setPhonenumber(user.getPhoneNumber());
        userData.setRole(user.getRole().get(0));
        return Mono.just(userData);
    }

    private UserData mapperDtoToData(User user){
        UserData userData = new UserData();
        userData.setFacebookid(user.getUsername());
        userData.setGoogleid(user.getPassword());
        userData.setEmail(user.getEmail());
        userData.setFirstname(user.getFirstName());
        userData.setLastname(user.getLastName());
        userData.setDocumentid(user.getDocumentId());
        userData.setDocumenttype(user.getDocumentType());
        userData.setPhonenumber(user.getPhoneNumber());
        userData.setRole(user.getRole().get(0));
        return userData;
    }

    private User mapperDataToDto(UserData userData){
        return User.builder()
                .username(userData.getFacebookid())
                .password(userData.getGoogleid())
                .email(userData.getEmail())
                .firstName(userData.getFirstname())
                .lastName(userData.getLastname())
                .documentId(userData.getDocumentid())
                .documentType(userData.getDocumenttype())
                .phoneNumber(userData.getPhonenumber())
                .role(Collections.singletonList(userData.getRole()))
                .build();
    }
}
