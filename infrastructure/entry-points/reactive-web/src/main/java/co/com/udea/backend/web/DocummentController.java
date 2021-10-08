package co.com.udea.backend.web;

import co.com.udea.backend.model.entities.Documment;
import co.com.udea.backend.model.entities.FinancialInformation;
import co.com.udea.backend.usecase.DocummentUseCase;
import co.com.udea.backend.web.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/documment")
@RequiredArgsConstructor
public class DocummentController {

    private final DocummentUseCase docummentUseCase;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping()
    public Mono<Documment> createDocumment(@RequestHeader("authorization") String token, @RequestBody Documment documment){
        String username = getUsername(token);
        return docummentUseCase.createDocumment(documment, username);
    }

    @GetMapping()
    public Mono<Documment> getFinancialInformation(@RequestHeader ("authorization") String token){
        String username = getUsername(token);
        return docummentUseCase.getDocummentById(username);
    }

    private String getUsername(String token){
        String jwt = token.substring(7, token.length());
        return jwtUtils.getUserNameFromJwtToken(jwt);
    }
}
