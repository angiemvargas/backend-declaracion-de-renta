package co.com.udea.backend.mysql.dtos;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "statement_date")
@Data
public class StatementDateData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String document_end;

    private Date date;
}
