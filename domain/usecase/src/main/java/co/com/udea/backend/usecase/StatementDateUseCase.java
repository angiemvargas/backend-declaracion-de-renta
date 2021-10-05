package co.com.udea.backend.usecase;

import co.com.udea.backend.model.entities.StatementDate;
import co.com.udea.backend.model.gateway.StatementDateGateway;
import co.com.udea.backend.model.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class StatementDateUseCase {

    private final StatementDateGateway statementDateGateway;
    private final UserGateway userGateway;

    public Mono<StatementDate> getStatementDate(String username){
        return Mono.just(userGateway.findByEmail(username))
                .flatMap(user -> findDocumentEndByDocument("1026290001"))
                .flatMap(statementDateGateway::findDateByDocumentEnd);
    }

    private Mono<String> findDocumentEndByDocument(String document){
        return Mono.just(document.substring(document.length()-2));
    }
}
