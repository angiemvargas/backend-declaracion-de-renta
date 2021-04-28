package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.AccountantData;
import org.springframework.data.repository.CrudRepository;

public interface AccountantRepository extends CrudRepository<AccountantData, Integer> {
}
