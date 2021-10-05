package co.com.udea.backend.web;

import co.com.udea.backend.model.entities.FinancialInformation;
import co.com.udea.backend.usecase.FinancialInformationUseCase;
import co.com.udea.backend.web.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/financialInformation")
@RequiredArgsConstructor
public class FinancialInformationController {

    private final FinancialInformationUseCase financialInformationUseCase;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/create")
    public Mono<FinancialInformation> createFinancialInformation(@RequestHeader ("authorization") String token, @RequestBody FinancialInformation financialInformation){
        String username = getUsername(token);
        return financialInformationUseCase.createFinancialInformation(financialInformation, username);
    }

    @PutMapping("/update")
    public Mono<FinancialInformation> updateFinancialInformation(@RequestHeader ("authorization") String token, @RequestBody FinancialInformation financialInformation){
        String username = getUsername(token);
        return financialInformationUseCase.updateFinancialInformation(financialInformation, username);
    }

    @GetMapping()
    public Mono<FinancialInformation> getFinancialInformation(@RequestHeader ("authorization") String token){
        String username = getUsername(token);
        return financialInformationUseCase.getFinancialInformationById(username);
    }

    @GetMapping("/validateDeclaration")
    public Mono<Boolean> validateDeclaration(@RequestHeader ("authorization") String token){
        String username = getUsername(token);
        return financialInformationUseCase.validateDeclaration(username);
    }

    private String getUsername(String token){
        String jwt = token.substring(7, token.length());
        return jwtUtils.getUserNameFromJwtToken(jwt);
    }

    //getEmailToken o id(retornar id) de infofinanciera
    //endpoint de drive, crear carpeta, agregar archivos, get de archivos(lista de nombres o link)
    //endpoint usuario-numero documento, basado en los 2 ultimos digitos, buscar es StatementDate por documentEnd y retorne la fecha o todo el registro(get)
    //info financiera del usaurio comparar con requisitos para la declaracion y retornar true or false(declaracion)

}
