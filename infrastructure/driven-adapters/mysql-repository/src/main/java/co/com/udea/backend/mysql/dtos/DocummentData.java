package co.com.udea.backend.mysql.dtos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "documments")
@Data
public class DocummentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer user_id;

    private String name;

    private String url;
}
