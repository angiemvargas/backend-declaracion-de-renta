package co.com.udea.backend.mysql.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Score {

    @Id
    private Integer id;

    private Integer value;

    private Integer userId;

    private Integer accountant;
}
