package co.com.udea.backend.mysql.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FinancialInformation {

    @Id
    private Integer user_id;

    private Integer income;

    private Integer consuption;

    private Integer bankConsignements;

    private Integer assetsValue;
}
