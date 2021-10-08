package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.DocummentData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocummentRepository extends CrudRepository<DocummentData, Integer> {

    @Query("SELECT d FROM DocummentData d WHERE d.user_id = :userId")
    List<DocummentData> findByUser_id(@Param("userId") Integer userId);
}
