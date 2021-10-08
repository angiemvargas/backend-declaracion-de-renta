package co.com.udea.backend.model.gateway;

import co.com.udea.backend.model.entities.Documment;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DocummentGateway {

    Mono<Documment> createDocumment(Documment documment);

    List<Documment> getDocummentById(Integer id);

    String deleteDocumment(Integer id);

}
