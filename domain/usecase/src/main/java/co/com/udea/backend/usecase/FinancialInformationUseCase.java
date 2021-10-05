package co.com.udea.backend.usecase;

import co.com.udea.backend.model.entities.FinancialInformation;
import co.com.udea.backend.model.gateway.FinancialInformationGateway;
import co.com.udea.backend.model.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
public class FinancialInformationUseCase {

    @Value("${app.uvt.4500}")
    private Integer uvt4500;

    @Value("${app.uvt.1400}")
    private Integer uvt1400;

    private final FinancialInformationGateway financialInformationGateway;
    private final UserGateway userGateway;

    public Mono<FinancialInformation> createFinancialInformation(FinancialInformation financialInformation, String username) {
        return Mono.just(userGateway.findByEmail(username))
        .flatMap(user -> financialInformationGateway.createFinancialInformation(factoryFinancial(financialInformation).userId(user.getId()).build()));
    }

    public Mono<FinancialInformation> updateFinancialInformation(FinancialInformation financialInformation, String username) {
        return Mono.just(userGateway.findByEmail(username))
                .flatMap(user -> financialInformationGateway.updateFinancialInformation(factoryFinancial(financialInformation).userId(user.getId()).build()));
    }

    public Mono<FinancialInformation> getFinancialInformationById(String username) {
        return Mono.just(userGateway.findByEmail(username))
                .flatMap(user -> financialInformationGateway.getFinancialInformationById(user.getId()));
    }

    public Mono<Boolean> validateDeclaration(String username){
        return Mono.just(userGateway.findByEmail(username))
                .flatMap(user -> financialInformationGateway.getFinancialInformationById(user.getId()))
                .flatMap(this::validateFieldDeclaration);
    }

    private Mono<Boolean> validateFieldDeclaration(FinancialInformation infoF) {
        if (Objects.isNull(infoF.getIncome())){
            return Mono.just(Boolean.FALSE);
        }
        if (infoF.getIncome() >= uvt1400 || infoF.getConsuption() >= uvt1400 || infoF.getBankConsignements() >= uvt1400
        || infoF.getLiabilitiesValue() >= uvt1400 || infoF.getAssetsValue() >= uvt4500){
            return Mono.just(Boolean.TRUE);
        }
        return Mono.just(Boolean.FALSE);
    }

    private FinancialInformation.FinancialInformationBuilder factoryFinancial(FinancialInformation financialInformation){
        return FinancialInformation
                .builder()
                .userId(financialInformation.getUserId())
                .income(financialInformation.getIncome())
                .consuption(financialInformation.getConsuption())
                .bankConsignements(financialInformation.getBankConsignements())
                .assetsValue(financialInformation.getAssetsValue())
                .liabilitiesValue(financialInformation.getLiabilitiesValue());
    }
}
