package co.com.udea.backend.mysql.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Documment {

    @Id
    private Integer id;

    private Integer userId;

    private String name;

    private String url;
}
