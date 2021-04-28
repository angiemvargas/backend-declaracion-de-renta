package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.ScoreData;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<ScoreData, Integer> {
}
