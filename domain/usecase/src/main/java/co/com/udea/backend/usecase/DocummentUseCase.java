package co.com.udea.backend.usecase;

import co.com.udea.backend.model.entities.Documment;
import co.com.udea.backend.model.entities.User;
import co.com.udea.backend.model.gateway.DocummentGateway;
import co.com.udea.backend.model.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class DocummentUseCase {

    private final DocummentGateway docummentGateway;
    private final UserGateway userGateway;

    public Mono<Documment> createDocumment(Documment documment, String username){
        return Mono.just(userGateway.findByEmail(username))
                .flatMap(user -> docummentGateway.createDocumment(factoryDocumment(documment).userId(user.getId()).build()));
    }

    public List<Documment> getDocummentById(String username) {
        User user = userGateway.findByEmail(username);
        return docummentGateway.getDocummentById(user.getId());
    }

    public String deleteDocumment(Integer id){
        return docummentGateway.deleteDocumment(id);
    }

    private Documment.DocummentBuilder factoryDocumment(Documment documment){
        return Documment.builder()
                .id(documment.getId())
                .userId(documment.getUserId())
                .name(documment.getName())
                .url(documment.getUrl());
    }
}
