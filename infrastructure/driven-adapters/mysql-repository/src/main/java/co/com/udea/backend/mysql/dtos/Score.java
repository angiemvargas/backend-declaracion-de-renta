package co.com.udea.backend.mysql.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Score {

    @Id
    private Integer id;

    private Integer value;

    private Integer user_id;

    private Integer accountant_user_id;
}
