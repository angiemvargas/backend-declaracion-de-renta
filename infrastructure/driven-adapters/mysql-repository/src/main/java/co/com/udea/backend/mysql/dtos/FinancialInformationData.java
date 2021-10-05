package co.com.udea.backend.mysql.dtos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "financial_information")
@Data
public class FinancialInformationData {

    @Id
    private Integer user_id;

    private Integer income;

    private Integer consuption;

    private Integer bankconsignements;

    private Integer assetsvalue;

    private Integer liabilitiesvalue;
}
