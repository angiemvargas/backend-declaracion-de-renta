package co.com.udea.backend.web;

import co.com.udea.backend.model.entities.User;
import co.com.udea.backend.usecase.UserUseCase;
import co.com.udea.backend.web.dtos.LoginRequest;
import co.com.udea.backend.web.dtos.TokenResponse;
import co.com.udea.backend.web.dtos.UserRequest;
import co.com.udea.backend.web.security.jwt.JwtUtils;
import co.com.udea.backend.web.security.services.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/user")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder encoder;

    @PostMapping("/create")
    public Mono<ResponseEntity> createUser(@RequestBody UserRequest userRequest){

        User userDB = userUseCase.findByEmail(userRequest.getEmail());

        if (Objects.nonNull(userDB)){
            return Mono.just(ResponseEntity
                    .badRequest()
                    .body("Error: el email ya existe"));
        }

        User user = User.builder()
                .username(userRequest.getIdGoogle())
                .password(encoder.encode(userRequest.getIdGoogle()))
                .email(userRequest.getEmail())
                .documentId(userRequest.getDocumentId())
                .documentType(userRequest.getDocumentType())
                .phoneNumber(userRequest.getPhoneNumber())
                .role(Collections.singletonList("USER"))
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .build();

        return userUseCase.createUser(user)
                .thenReturn(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body("El usuario se a creado exitosamente"));

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getIdGoogle()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(TokenResponse.builder()
                .email(userDetails.getEmail())
                .token(jwt)
                .typeToken("Bearer")
                .build());
    }

    @PutMapping("/update")
    public Mono<User> updateUser(@RequestBody User user){
        return userUseCase.updateUser(user);
    }
}
