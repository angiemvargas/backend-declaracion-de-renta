package co.com.udea.backend.mysql.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Integer id;

    private String facebookId;

    private String googleId;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String role;

}
