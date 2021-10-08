package co.com.udea.backend.model.gateway;

import co.com.udea.backend.model.entities.Documment;
import reactor.core.publisher.Mono;

public interface DocummentGateway {

    Mono<Documment> createDocumment(Documment documment);

    Mono<Documment> getDocummentById(Integer id);

}
