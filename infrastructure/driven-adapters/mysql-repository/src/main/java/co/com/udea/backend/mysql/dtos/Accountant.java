package co.com.udea.backend.mysql.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accountant {

    @Id
    private Integer user_id;

    private String contactEmail;

    private String contactPhone;

    private String information;

    private String pricing;

    private String enable;
}
