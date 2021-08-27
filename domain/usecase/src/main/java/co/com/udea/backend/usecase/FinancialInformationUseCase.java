package co.com.udea.backend.usecase;

import co.com.udea.backend.model.entities.FinancialInformation;
import co.com.udea.backend.model.gateway.FinancialInformationGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FinancialInformationUseCase {

    private final FinancialInformationGateway financialInformationGateway;

    public Mono<FinancialInformation> createFinancialInformation(FinancialInformation financialInformation){
        return financialInformationGateway.createFinancialInformation(financialInformation);
    }

    public Mono<FinancialInformation> updateFinancialInformation(FinancialInformation financialInformation){
        return financialInformationGateway.updateFinancialInformation(financialInformation);
    }
}
