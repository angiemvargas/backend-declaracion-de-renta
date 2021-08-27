package co.com.udea.backend.model.gateway;

import co.com.udea.backend.model.entities.FinancialInformation;
import reactor.core.publisher.Mono;

public interface FinancialInformationGateway {

    Mono<FinancialInformation> createFinancialInformation(FinancialInformation financialInformation);

    Mono<FinancialInformation> updateFinancialInformation(FinancialInformation financialInformation);
}
