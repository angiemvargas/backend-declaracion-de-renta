package co.com.udea.backend.web;

import co.com.udea.backend.model.entities.FinancialInformation;
import co.com.udea.backend.usecase.FinancialInformationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="/financialInformation")
@RequiredArgsConstructor
public class FinancialInformationController {

    private final FinancialInformationUseCase financialInformationUseCase;

    @PostMapping("/create")
    public Mono<FinancialInformation> createFinancialInformation(@RequestBody FinancialInformation financialInformation){
        return financialInformationUseCase.createFinancialInformation(financialInformation);
    }

    @PutMapping("/update")
    public Mono<FinancialInformation> updateFinancialInformation(@RequestBody FinancialInformation financialInformation){
        return financialInformationUseCase.updateFinancialInformation(financialInformation);
    }
}
