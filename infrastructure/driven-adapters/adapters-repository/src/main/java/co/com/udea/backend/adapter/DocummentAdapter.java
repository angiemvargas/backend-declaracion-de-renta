package co.com.udea.backend.adapter;

import co.com.udea.backend.model.entities.Documment;
import co.com.udea.backend.model.entities.FinancialInformation;
import co.com.udea.backend.model.gateway.DocummentGateway;
import co.com.udea.backend.mysql.dtos.DocummentData;
import co.com.udea.backend.mysql.repository.DocummentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class DocummentAdapter implements DocummentGateway {

    private final DocummentRepository docummentRepository;

    @Override
    public Mono<Documment> createDocumment(Documment documment) {
        DocummentData data = mapperDtoToData(documment);
        return Mono.just(docummentRepository.save(data))
                .flatMap(docummentData -> mapperDataToDto(data));
    }

    @Override
    public Mono<Documment> getDocummentById(Integer id) {
        DocummentData docummentData = docummentRepository.findByUser_id(id);

        if (Objects.isNull(docummentData)){
            return Mono.just(new Documment());
        }
        return mapperDataToDto(docummentData);
    }


    private DocummentData mapperDtoToData(Documment documment){
        DocummentData docummentData = new DocummentData();
        docummentData.setId(documment.getId());
        docummentData.setUser_id(documment.getUserId());
        docummentData.setName(documment.getName());
        docummentData.setUrl(documment.getUrl());
        return docummentData;
    }

    private Mono<Documment> mapperDataToDto(DocummentData docummentData){
        return Mono.just(Documment.builder()
                .id(docummentData.getId())
                .userId(docummentData.getUser_id())
                .name(docummentData.getName())
                .url(docummentData.getUrl())
                .build());
    }
}
