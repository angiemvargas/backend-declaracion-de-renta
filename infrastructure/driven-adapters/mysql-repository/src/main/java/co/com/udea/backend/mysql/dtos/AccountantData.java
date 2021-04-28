package co.com.udea.backend.mysql.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccountantData {

    @Id
    private Integer userId;

    private String contactEmail;

    private String contactPhone;

    private String information;

    private String pricing;

    private String enable;
}
