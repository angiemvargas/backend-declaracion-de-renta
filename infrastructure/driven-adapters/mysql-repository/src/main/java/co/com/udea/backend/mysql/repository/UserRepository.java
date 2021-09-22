package co.com.udea.backend.mysql.repository;

import co.com.udea.backend.mysql.dtos.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData, Integer> {

    UserData findByEmail(String email);
}
