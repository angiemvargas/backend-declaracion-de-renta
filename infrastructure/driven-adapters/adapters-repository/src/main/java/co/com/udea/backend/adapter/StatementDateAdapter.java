package co.com.udea.backend.adapter;

import co.com.udea.backend.model.entities.StatementDate;
import co.com.udea.backend.model.gateway.StatementDateGateway;
import co.com.udea.backend.mysql.dtos.StatementDateData;
import co.com.udea.backend.mysql.repository.StatementDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class StatementDateAdapter implements StatementDateGateway {

    private final StatementDateRepository statementDateRepository;

    @Override
    public Mono<StatementDate> findDateByDocumentEnd(String documentEnd) {
        return Mono.just(statementDateRepository.findByDocument_end(documentEnd))
                .flatMap(this::mapperDataToDTO);
    }

    private Mono<StatementDate> mapperDataToDTO(StatementDateData statementDateData){
        return Mono.just(StatementDate.builder()
                .id(statementDateData.getId())
                .date(statementDateData.getDate())
                .documentEnd(statementDateData.getDocument_end())
                .build());
    }


}
