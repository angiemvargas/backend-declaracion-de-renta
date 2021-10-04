package co.com.udea.backend.usecase;

import co.com.udea.backend.model.entities.FinancialInformation;
import co.com.udea.backend.model.gateway.FinancialInformationGateway;
import co.com.udea.backend.model.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FinancialInformationUseCase {

    private final FinancialInformationGateway financialInformationGateway;
    private final UserGateway userGateway;

    public Mono<FinancialInformation> createFinancialInformation(FinancialInformation financialInformation) {
        return financialInformationGateway.createFinancialInformation(financialInformation);
    }

    public Mono<FinancialInformation> updateFinancialInformation(FinancialInformation financialInformation) {
        return financialInformationGateway.updateFinancialInformation(financialInformation);
    }

    public Mono<FinancialInformation> getFinancialInformationById(String username) {
        return Mono.just(userGateway.findByEmail(username))
                .flatMap(user -> financialInformationGateway.getFinancialInformationById(user.getId()));
    }
}
