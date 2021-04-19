package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Integer> {
}
