package co.com.udea.backend.mysql.dtos;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "user")
@Data
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String facebookid;

    private String googleid;

    private String email;

    private String firstname;

    private String lastname;

    private String documentid;

    private String documenttype;

    private String phonenumber;

    private String role;

}
