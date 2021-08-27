package co.com.udea.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinancialInformation {

    private Integer userId;
    private Integer income;
    private Integer consuption;
    private Integer bankConsignements;
    private Integer assetsValue;
    private Integer liabilitiesValue;
}
