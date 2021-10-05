package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.FinancialInformationData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FinancialInformationRepository extends CrudRepository<FinancialInformationData, Integer> {

    @Query("SELECT if FROM FinancialInformationData if WHERE if.user_id = :userId")
    FinancialInformationData findByUser_id(@Param("userId") Integer userId);

}
