package co.com.udea.backend.adapter;

import co.com.udea.backend.model.entities.Documment;
import co.com.udea.backend.model.gateway.DocummentGateway;
import co.com.udea.backend.mysql.dtos.DocummentData;
import co.com.udea.backend.mysql.repository.DocummentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DocummentAdapter implements DocummentGateway {

    private final DocummentRepository docummentRepository;

    @Override
    public Mono<Documment> createDocumment(Documment documment) {
        DocummentData data = mapperDtoToData(documment);
        return Mono.just(docummentRepository.save(data))
                .flatMap(docummentData -> Mono.just(mapperDataToDto(data)));
    }

    @Override
    public List<Documment> getDocummentById(Integer id) {
        List<DocummentData> docummentData = docummentRepository.findByUser_id(id);

        if (Objects.isNull(docummentData)){
            return Collections.singletonList(new Documment());
        }
        return docummentData.stream()
                .map(this::mapperDataToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteDocumment(Integer id) {
        docummentRepository.deleteById(id);
        return "Se elimino el documento con exito";
    }


    private DocummentData mapperDtoToData(Documment documment){
        DocummentData docummentData = new DocummentData();
        docummentData.setId(documment.getId());
        docummentData.setUser_id(documment.getUserId());
        docummentData.setName(documment.getName());
        docummentData.setUrl(documment.getUrl());
        return docummentData;
    }

    private Documment mapperDataToDto(DocummentData docummentData){
        return Documment.builder()
                .id(docummentData.getId())
                .userId(docummentData.getUser_id())
                .name(docummentData.getName())
                .url(docummentData.getUrl())
                .build();
    }
}
