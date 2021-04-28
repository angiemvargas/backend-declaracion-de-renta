package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.FinancialInformationData;
import org.springframework.data.repository.CrudRepository;

public interface FinancialInformationRepository extends CrudRepository<FinancialInformationData, Integer> {
}
