package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.DocummentData;
import org.springframework.data.repository.CrudRepository;

public interface DocummentRepository extends CrudRepository<DocummentData, Integer> {
}
