package co.com.udea.backend;

import co.com.udea.backend.model.gateway.FinancialInformationGateway;
import co.com.udea.backend.model.gateway.StatementDateGateway;
import co.com.udea.backend.model.gateway.UserGateway;
import co.com.udea.backend.usecase.FinancialInformationUseCase;
import co.com.udea.backend.usecase.StatementDateUseCase;
import co.com.udea.backend.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public UserUseCase userUseCase(UserGateway userGateway) {
        return new UserUseCase(userGateway);
    }

    @Bean
    public FinancialInformationUseCase financialInformationUseCase(FinancialInformationGateway financialInformationGateway,
                                                                   UserGateway userGateway) {
        return new FinancialInformationUseCase(financialInformationGateway, userGateway);
    }

    @Bean
    public StatementDateUseCase statementDateUseCase(StatementDateGateway statementDateGateway, UserGateway userGateway) {
        return new StatementDateUseCase(statementDateGateway, userGateway);
    }
}
