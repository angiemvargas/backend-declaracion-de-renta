package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.StatementDateData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StatementDateRepository extends CrudRepository<StatementDateData, Integer> {

    @Query("SELECT sd FROM StatementDateData sd WHERE sd.document_end = :documentEnd")
    StatementDateData findByDocument_end(@Param("documentEnd") String documentEnd);
}
