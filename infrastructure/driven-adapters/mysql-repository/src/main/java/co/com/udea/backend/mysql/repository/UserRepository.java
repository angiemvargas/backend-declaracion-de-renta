package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
