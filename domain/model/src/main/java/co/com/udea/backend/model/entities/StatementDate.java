package co.com.udea.backend.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StatementDate {

    private Integer id;
    private String documentEnd;
    private Date date;
}
