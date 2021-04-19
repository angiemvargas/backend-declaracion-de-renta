package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.FinancialInformation;
import org.springframework.data.repository.CrudRepository;

public interface FinancialInformationRepository extends CrudRepository<FinancialInformation, Integer> {
}
