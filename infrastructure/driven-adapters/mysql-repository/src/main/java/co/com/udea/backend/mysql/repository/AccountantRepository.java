package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.Accountant;
import org.springframework.data.repository.CrudRepository;

public interface AccountantRepository extends CrudRepository<Accountant, Integer> {
}
