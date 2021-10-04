package co.com.udea.backend.web;

import co.com.udea.backend.model.entities.StatementDate;
import co.com.udea.backend.usecase.StatementDateUseCase;
import co.com.udea.backend.web.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/statementDate")
@RequiredArgsConstructor
public class StatementDateController {

    private final StatementDateUseCase statementDateUseCase;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping()
    public Mono<StatementDate> getStatementDate(@RequestHeader("authorization") String token){
        String jwt = token.substring(7, token.length());
        String username = jwtUtils.getUserNameFromJwtToken(jwt);
        return statementDateUseCase.getStatementDate(username);
    }
}
