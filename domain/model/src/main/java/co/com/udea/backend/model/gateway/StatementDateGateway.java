package co.com.udea.backend.model.gateway;

import co.com.udea.backend.model.entities.StatementDate;
import reactor.core.publisher.Mono;

public interface StatementDateGateway {

    Mono<StatementDate> findDateByDocumentEnd(String documentEnd);
}
